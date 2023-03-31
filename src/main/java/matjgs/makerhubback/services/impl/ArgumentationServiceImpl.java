package matjgs.makerhubback.services.impl;

import matjgs.makerhubback.models.dto.ArgumentationDTO;
import matjgs.makerhubback.repository.ArgumentationRepository;
import matjgs.makerhubback.services.ArgumentationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArgumentationServiceImpl implements ArgumentationService {
    private final ArgumentationRepository argumentationRepository;

    public ArgumentationServiceImpl(ArgumentationRepository argumentationRepository) {
        this.argumentationRepository = argumentationRepository;
    }

    @Override
    public List<ArgumentationDTO> getAll() {
        return argumentationRepository.findAll().stream()
                .map(ArgumentationDTO::toDto)
                .toList();
    }
}
