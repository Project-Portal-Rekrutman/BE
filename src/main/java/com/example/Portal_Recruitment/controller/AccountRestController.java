package com.example.Portal_Recruitment.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.dialect.MySQL55Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.dto.Login;
import com.example.Portal_Recruitment.dto.Register;
import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.model.Completion;
import com.example.Portal_Recruitment.model.JwtResponse;
import com.example.Portal_Recruitment.model.Participant;
import com.example.Portal_Recruitment.model.Role;
import com.example.Portal_Recruitment.model.User;
import com.example.Portal_Recruitment.repository.CompletionRepository;
import com.example.Portal_Recruitment.repository.ParticipantRepository;
import com.example.Portal_Recruitment.repository.RoleRepository;

@RestController
@RequestMapping("api")
public class AccountRestController {
    @Autowired
    private com.example.Portal_Recruitment.repository.UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
   
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private com.example.Portal_Recruitment.config.MyUserDetails myUserDetails;
    @Autowired
    private com.example.Portal_Recruitment.config.JwtTokenUtil jwtTokenUtil;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private CompletionRepository completionRepository;

    // @PostMapping("account/form-change-password")
    // public ResponseEntity<Object> checkPassword(@RequestBody ChangePassword
    // changePassword) {

    // final String requestTokenHeader = request.getHeader("Authorization");
    // String username = null;
    // String jwtToken = null;
    // jwtToken = requestTokenHeader.substring(7);
    // username = jwtTokenUtil.getUsernameFromToken(jwtToken);

    // ResponseChangePassword responChangePassword =
    // userRepository.findUser(username);
    // if (changePassword.getNewPassword().isEmpty() ||
    // changePassword.getNewPassword().equals(null)) {
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST,
    // "the field cannot be empty, check your input");
    // }
    // String newPassword = passwordEncoder.encode(changePassword.getNewPassword());
    // changePassword.setNewPassword(newPassword);
    // if (responChangePassword.getEmail().equals(null) &&
    // responChangePassword.getPassword().equals(null)) {
    // return CustomResponse.generate(HttpStatus.OK, "user not found");
    // } else if
    // (changePassword.getNewPassword().equals(responChangePassword.getPassword()))
    // {
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST,
    // "The new password cannot be the same as the old password");
    // } else if
    // (passwordEncoder.matches(changePassword.getOldPassword(),responChangePassword.getPassword())==
    // false) {
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST, "password does not
    // match");
    // }else if (changePassword.getOldPassword().isEmpty() ||
    // changePassword.getOldPassword().equals(null)) {
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST,
    // "the field cannot be empty, check your input");
    // } else {
    // User user = userRepository.findByEmail(username);
    // user.setPassword(changePassword.getNewPassword());
    // userRepository.save(user);
    // return CustomResponse.generate(HttpStatus.CREATED, "successfully changed your
    // password");
    // }
    // }

    // // @PreAuthorize("")
    // @PostMapping("account/register")
    // public ResponseEntity<Object> save(@RequestBody Register register) {
    // String emailExist = employeeRepository.findEmail(register.getEmail());
    // if (emailExist == null) {
    // Employee employee = new Employee();
    // employee.setName(register.getName());
    // employee.setEmail(register.getEmail());
    // employeeRepository.save(employee);
    // Boolean result = employeeRepository.findById(employee.getId()).isPresent();
    // if (result) {
    // User user = new User();
    // user.setId(employee.getId());
    // user.setPassword(passwordEncoder.encode(register.getPassword()));
    // Role role = roleRepository.findById(5).orElse(null);
    // user.setRole(role);
    // userRepository.save(user);
    // Boolean resultUser = userRepository.findById(employee.getId()).isPresent();
    // if (resultUser) {
    // return CustomResponse.generate(HttpStatus.OK, "Register Successfully");
    // }else{
    // employeeRepository.deleteById(employee.getId());
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Register Failed");
    // }
    // }
    // }
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Register Failed");
    // }

    @PostMapping("account/authenticating")
    public ResponseEntity<Object> login(@RequestBody Login login) {

        try {

            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = myUserDetails.loadUserByUsername(login.getEmail());

            // myUserDetails = (MyUserDetails)
            // myUserDetails.loadUserByUsername(login.getEmail());

            final String token = jwtTokenUtil.generateToken(userDetails);
            String username = jwtTokenUtil.getUsernameFromToken(token);
            com.example.Portal_Recruitment.model.User user = userRepository.getrole(username);

            return CustomResponse.generate(HttpStatus.OK, "Login Sukses", token, user.getRole().getName());
        } catch (Exception e) {
            return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Login Failed", null);
        }
    }

    // @PostMapping("account/forgot-password")
    // public ResponseEntity<Object> checkEmail(@RequestBody ForgotPassword
    // forgotPassword) {
    // // , @RequestHeader(name = "fp-nsr") String token
    // // if (token.equals(parameterRepository.findById("fp-nsr").get().getValue()))
    // {
    // // menggunakan line dibawah ini untuk get data sekaligus dengan cek email
    // User user = userRepository.findUserByEmail(forgotPassword.getEmail());
    // if (user.getEmployee().getEmail().equals(forgotPassword.getEmail())) {
    // user.setPassword(passwordEncoder.encode(forgotPassword.getPassword()));
    // userRepository.save(user);
    // // Method dalam Class CustomResponse dibuat static sehingga hanya perlu
    // // memanggil classnya saja
    // return CustomResponse.generate(HttpStatus.OK, "Your Password has been
    // Reset");
    // }
    // // }
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Wrong Token");
    // }

    // @PostMapping("account/register")
    // public ResponseEntity<Object> save(@RequestBody Register register) {
    // String emailExist = employeeRepository.findEmail(register.getEmail());
    // if (emailExist == null) {
    // Employee employee = new Employee();
    // employee.setName(register.getName());
    // employee.setEmail(register.getEmail());
    // employeeRepository.save(employee);
    // Boolean result = employeeRepository.findById(employee.getId()).isPresent();
    // if (result) {
    // User user = new User();
    // user.setId(employee.getId());
    // user.setPassword(passwordEncoder.encode(register.getPassword()));
    // Role role = roleRepository.findById(5).orElse(null);
    // user.setRole(role);
    // userRepository.save(user);
    // Boolean resultUser = userRepository.findById(employee.getId()).isPresent();
    // if (resultUser) {
    // return CustomResponse.generate(HttpStatus.OK, "Register Successfully");
    // }else{
    // employeeRepository.deleteById(employee.getId());
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Register Failed");
    // }
    // }
    // }
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Register Failed");
    // }

    @PostMapping("account/register-jobseeker")
    public ResponseEntity<Object> registerJobseeker(@RequestBody Register register) {
        String emailExist = userRepository.findEmail(register.getEmail());
        if (register.getName().isEmpty() || register.getEmail().isEmpty() || register.getPassword().isEmpty()) {
            return CustomResponse.generate(HttpStatus.BAD_REQUEST, "the field cannot be empty, check your input");
        } else if (emailExist == null) {
            com.example.Portal_Recruitment.model.User user = new com.example.Portal_Recruitment.model.User();
            user.setEmail(register.getEmail());
            user.setPassword(passwordEncoder.encode(register.getPassword()));
            user.setName(register.getName());
            Role role = roleRepository.findById(3).orElse(null);
            user.setRole(role);
            userRepository.save(user);
            Boolean resultUser = userRepository.findById(user.getId()).isPresent();
            if (resultUser) {
                Participant participant = new Participant();
                participant.setId(user.getId());
                participantRepository.save(participant);
                Boolean resultParticipant = participantRepository.findById(participant.getId()).isPresent();
                if (resultParticipant) {
                    Completion completion = new Completion();
                    completion.setId(participant.getId());
                    completionRepository.save(completion);
                    Boolean resultCompletion = completionRepository.findById(completion.getId()).isPresent();
                    if (resultCompletion) {
                        return CustomResponse.generate(HttpStatus.CREATED, "Register Success");
                    }else{
                        participantRepository.deleteById(participant.getId());
                        return CustomResponse.generate(HttpStatus.BAD_REQUEST,
                            "Register failed because server failed save user");
                    } 
                } else {
                    userRepository.deleteById(user.getId());
                    return CustomResponse.generate(HttpStatus.BAD_REQUEST,
                            "Register failed because server failed save user");
                }
            } else {
                return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Register failed, please check your input");
            }
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Register failed, because email is already registered");
    }

    @PostMapping("account/register-recruiter")
    public ResponseEntity<Object> registerRecruiter(@RequestBody Register register) {
        String emailExist = userRepository.findEmail(register.getEmail());
        if (register.getName().isEmpty() || register.getEmail().isEmpty() || register.getPassword().isEmpty()) {
            return CustomResponse.generate(HttpStatus.BAD_REQUEST, "the field cannot be empty, check your input");
        } else if (emailExist == null) {
            com.example.Portal_Recruitment.model.User user = new com.example.Portal_Recruitment.model.User();
            user.setEmail(register.getEmail());
            user.setPassword(passwordEncoder.encode(register.getPassword()));
            user.setName(register.getName());
            Role role = roleRepository.findById(2).orElse(null);
            user.setRole(role);
            userRepository.save(user);
            Boolean resultUser = userRepository.findById(user.getId()).isPresent();
            if (resultUser) {
                return CustomResponse.generate(HttpStatus.CREATED, "Register Success"); 
            }else{
                return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Register failed, please check your input");
            }
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Register failed, because email is already registered");
    }
}
