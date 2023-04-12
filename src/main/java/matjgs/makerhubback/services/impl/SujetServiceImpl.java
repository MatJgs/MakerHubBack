package matjgs.makerhubback.services.impl;

import matjgs.makerhubback.exceptions.NotFoundException;
import matjgs.makerhubback.models.dto.SujetDTO;
import matjgs.makerhubback.models.entity.Sujet;
import matjgs.makerhubback.models.entity.Utilisateur;
import matjgs.makerhubback.models.form.SujetForm;
import matjgs.makerhubback.repository.ArgumentationRepository;
import matjgs.makerhubback.repository.SujetRepository;
import matjgs.makerhubback.repository.UtilisateurRepository;
import matjgs.makerhubback.services.SujetService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

@Service
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;
    private final ArgumentationRepository argumentationRepository;

    private final UtilisateurRepository utilisateurRepository;

    public SujetServiceImpl(SujetRepository sujetRepository,
                            ArgumentationRepository argumentationRepository,
                            UtilisateurRepository utilisateurRepository) {
        this.sujetRepository = sujetRepository;
        this.argumentationRepository = argumentationRepository;
        this.utilisateurRepository=utilisateurRepository;
    }

    @Override
    public SujetDTO getOne(Long id) {

        return sujetRepository.findById(id)
                .map(SujetDTO::toDto)
                .orElseThrow( () -> new RuntimeException("not found") ); // TODO: préciser

    }

    @Override
    public void create(SujetForm form) {
        Sujet sujet = form.toEntity();

        Utilisateur p = utilisateurRepository.findByLogin(form.getUserLogin())
                .orElseThrow( () -> new NotFoundException(Utilisateur.class, form.getUserLogin()) );



        if (form.getArgumentsId()!=null){
            sujet.setArgumentations(
                new HashSet<>(argumentationRepository.findAllById(form.getArgumentsId()))
            );
        }
        sujet.setSujetBy(p);
        sujetRepository.save(sujet);
    }

    @Override
    public List<SujetDTO> getAll() {
        return sujetRepository.findAll().stream()
                .map(SujetDTO::toDto)
                .toList();
    }
}
