package peaksoft.springsecurityexamwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.springsecurityexamwork.entity.Variant;
import peaksoft.springsecurityexamwork.repository.VariantRepository;
import peaksoft.springsecurityexamwork.service.VariantService;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class VariantServiceImpl implements VariantService {
    private final VariantRepository variantRepository;
    @Override
    public Variant saveUser(Variant variant) {
        return variantRepository.save(variant);
    }

    @Override
    public List<Variant> findAllUsers() {
        return variantRepository.findAll();
    }

    @Override
    public Optional<Variant> findById(Long id) {
        return variantRepository.findById( id);
    }

    @Override
    public void deleteById(Long id) {
      variantRepository.deleteById(id);
    }
}
