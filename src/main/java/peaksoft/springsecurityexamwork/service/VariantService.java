package peaksoft.springsecurityexamwork.service;


import peaksoft.springsecurityexamwork.entity.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantService {
    public Variant saveUser(Variant variant);

    List<Variant> findAllUsers();

    Optional<Variant> findById(Long id);

    void deleteById(Long id);
}
