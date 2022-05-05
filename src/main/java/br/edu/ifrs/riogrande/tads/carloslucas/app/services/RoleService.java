package br.edu.ifrs.riogrande.tads.carloslucas.app.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.carloslucas.app.exceptions.NotFoundException;
import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Role;
import br.edu.ifrs.riogrande.tads.carloslucas.app.repository.RoleRepository;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.RoleRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public void save(RoleRequest request) {
        Role role = new Role();
        role.setRole(request.getRole());

        roleRepository.save(role);
    }

    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

    public List<Role> listAll() {
        return roleRepository.findAll();
    }

    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public void update(Integer id, @Valid RoleRequest body) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role não encontrada"));

        role.setRole(body.getRole());

        roleRepository.save(role);
    }

    public Role show(Integer id) {
        return this.findById(id)
                .orElseThrow(() -> new NotFoundException("Role não Encontrada"));
            
    }
}
