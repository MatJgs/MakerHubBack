package matjgs.makerhubback.services.impl;

import matjgs.makerhubback.models.dto.ArgumentationDTO;
import matjgs.makerhubback.models.entity.Argumentation;
import matjgs.makerhubback.models.entity.Sujet;
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

        argumentation.setArgumentBy(utilisateurRepository.getReferenceById(form.getAuteurId()));

        argumentation.setSujet(sujetRepository.findById(form.getSujetId()).get());

        argumentationRepository.save(argumentation);
    }
}
