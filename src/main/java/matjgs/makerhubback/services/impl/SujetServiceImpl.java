package matjgs.makerhubback.services.impl;

import matjgs.makerhubback.exceptions.NotFoundException;
import matjgs.makerhubback.models.dto.SujetDTO;
import matjgs.makerhubback.models.entity.Sujet;
import matjgs.makerhubback.models.entity.users.Utilisateur;
import matjgs.makerhubback.models.form.SujetForm;
import matjgs.makerhubback.repository.ArgumentationRepository;
import matjgs.makerhubback.repository.SujetRepository;
import matjgs.makerhubback.repository.UtilisateurRepository;
import matjgs.makerhubback.services.SujetService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import java.util.List;
import java.util.Objects;

@Service
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;

    private final UtilisateurRepository utilisateurRepository;

    public SujetServiceImpl(SujetRepository sujetRepository,
                            UtilisateurRepository utilisateurRepository) {
        this.sujetRepository = sujetRepository;

        this.utilisateurRepository=utilisateurRepository;
    }

    @Override
    public SujetDTO getOne(Long id) {

        return sujetRepository.findById(id)
                .map(SujetDTO::toDto)
                .orElseThrow( () -> new NotFoundException(Sujet.class,sujetRepository) );

    }

    @Override
    public void create(SujetForm form) {
        Sujet sujet = form.toEntity();
        sujet.setEnabled(true);
        sujet.setHidden(false);

        Utilisateur p = utilisateurRepository.findByLogin(form.getUserLogin())
                .orElseThrow( () -> new NotFoundException(Utilisateur.class, form.getUserLogin()) );

        sujet.setSujetBy(p);
        sujetRepository.save(sujet);
    }

    @Override
    public List<SujetDTO> getAll() {
        return sujetRepository.findAll().stream()
                .map(SujetDTO::toDto)
                .toList();
    }




    @Override
    public void cloture(Long id,String username) {
        Utilisateur p = utilisateurRepository.findByLogin(username)
            .orElseThrow( () -> new NotFoundException(Utilisateur.class, username) );
        if (Objects.equals(p.getRole(), "TECHNOBEL") ){
            Sujet sujet = sujetRepository.findById(id).orElseThrow(() -> new NotFoundException(Sujet.class, id));
            if (sujet.isEnabled())
                sujet.setEnabled(false);
            else
                sujet.setEnabled(true);
            sujetRepository.save(sujet);
        }
    }

    @Override
    public void cacher(Long id, String username) {
        Utilisateur p = utilisateurRepository.findByLogin(username)
                .orElseThrow( () -> new NotFoundException(Utilisateur.class, username) );
        if (Objects.equals(p.getRole(), "TECHNOBEL") ) {
            Sujet sujet = sujetRepository.findById(id).orElseThrow(() -> new NotFoundException(Sujet.class, id));

            if (sujet.isHidden())
                sujet.setHidden(false);
            else
                sujet.setHidden(true);
            sujetRepository.save(sujet);

        }
    }
}
