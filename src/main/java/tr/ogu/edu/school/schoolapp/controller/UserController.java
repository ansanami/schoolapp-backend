package tr.ogu.edu.school.schoolapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import tr.ogu.edu.school.schoolapp.dto.UserDto;
import tr.ogu.edu.school.schoolapp.dto.UserLoginDto;
import tr.ogu.edu.school.schoolapp.mapper.UserMapper;
import tr.ogu.edu.school.schoolapp.model.User;
import tr.ogu.edu.school.schoolapp.service.AuthenticationService;
import tr.ogu.edu.school.schoolapp.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

	private final UserService userService;
	private final AuthenticationService authenticationService;
//	private final JwtUtil jwtUtil;

	@GetMapping(value = "authenticated")
	public ResponseEntity<UserDto> getAuthenticatedUser() {
		try {
			User user = authenticationService.getAuthenticatedUser();
			UserDto userDto = UserMapper.toUserDto(user);
			return ResponseEntity.ok(userDto);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getUsers() {
		List<User> users = userService.getAllUsers();
		List<UserDto> userDtos = users.stream().map(UserMapper::toUserDto).toList();
		return ResponseEntity.ok(userDtos);
	}
	@GetMapping(value = "/{tckn}")
	public ResponseEntity<UserDto> getUser(@PathVariable String tckn) {
		User user = userService.getUser(tckn);
		UserDto userDto = UserMapper.toUserDto(user);
		return ResponseEntity.ok(userDto);
	}

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		User user = UserMapper.fromUserDto(userDto);
		User createdUser = userService.createUser(user);
		UserDto createdUserDto = UserMapper.toUserDto(createdUser);
		return ResponseEntity.ok(createdUserDto);
	}

	@PutMapping
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
		User user = UserMapper.fromUserDto(userDto);
		User updatedUser = userService.updateUser(user);
		return ResponseEntity.ok(UserMapper.toUserDto(updatedUser));
	}

	@DeleteMapping
	public ResponseEntity<Boolean> deleteUser(@RequestBody Long ıd) {
		boolean result = userService.deleteUser(ıd);
		return result ? ResponseEntity.ok(true) : ResponseEntity.notFound().build();
	}

	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody UserLoginDto userLoginDto) {
		User authenticatedUser = authenticationService.authenticateUser(userLoginDto.getTckn(),
				userLoginDto.getPassword());
		if (authenticatedUser != null) {
			UserDto userDto = UserMapper.toUserDto(authenticatedUser);
			return ResponseEntity.ok(userDto);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}


}
