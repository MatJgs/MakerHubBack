package matjgs.makerhubback.services.impl;

import matjgs.makerhubback.models.dto.SujetDTO;
import matjgs.makerhubback.models.entity.Sujet;
import matjgs.makerhubback.models.form.SujetForm;
import matjgs.makerhubback.repository.ArgumentationRepository;
import matjgs.makerhubback.repository.SujetRepository;
import matjgs.makerhubback.services.SujetService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;
    private final ArgumentationRepository argumentationRepository;

    public SujetServiceImpl(SujetRepository sujetRepository,
                            ArgumentationRepository argumentationRepository) {
        this.sujetRepository = sujetRepository;
        this.argumentationRepository = argumentationRepository;
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

        sujet.setArgumentations(
                new LinkedHashSet<>(argumentationRepository.findAllById(form.getArgumentsId()))
        );

        sujetRepository.save(sujet);
    }
}