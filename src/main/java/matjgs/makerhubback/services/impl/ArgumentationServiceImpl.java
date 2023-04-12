package matjgs.makerhubback.services.impl;

import matjgs.makerhubback.exceptions.NotFoundException;
import matjgs.makerhubback.models.dto.ArgumentationDTO;
import matjgs.makerhubback.models.entity.Argumentation;
import matjgs.makerhubback.models.entity.Sujet;
import matjgs.makerhubback.models.entity.Utilisateur;
import matjgs.makerhubback.models.form.ArgumentationForm;
import matjgs.makerhubback.repository.ArgumentationRepository;
import matjgs.makerhubback.repository.SujetRepository;
import matjgs.makerhubback.repository.UtilisateurRepository;
import matjgs.makerhubback.services.ArgumentationService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ArgumentationServiceImpl implements ArgumentationService {
    private final ArgumentationRepository argumentationRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final SujetRepository sujetRepository;

    public ArgumentationServiceImpl(ArgumentationRepository argumentationRepository,UtilisateurRepository utilisateurRepository,
                                    SujetRepository sujetRepository) {
        this.argumentationRepository = argumentationRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.sujetRepository = sujetRepository;
    }

    @Override
    public List<ArgumentationDTO> getAll() {
        return argumentationRepository.findAll().stream()
                .map(ArgumentationDTO::toDto)
                .toList();
    }

    @Override
    public void create(ArgumentationForm form) {
        Argumentation argumentation = form.toEntity();

        Utilisateur p = utilisateurRepository.findByLogin(form.getUserLogin())
                .orElseThrow( () -> new NotFoundException(Utilisateur.class, form.getUserLogin()) );

        argumentation.setSujet(sujetRepository.findById(form.getSujetId()).get());

        argumentation.setArgumentBy(p);

        argumentationRepository.save(argumentation);
    }
}
