package peaksoft.springsecurityexamwork.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import peaksoft.springsecurityexamwork.entity.Role;
import peaksoft.springsecurityexamwork.entity.User;
import peaksoft.springsecurityexamwork.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userService.findAllUsers());
    }
    @PostMapping("user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
    @Data
    class RoleToUserForm {
    private String username;
    private String roleName;
    }
}
