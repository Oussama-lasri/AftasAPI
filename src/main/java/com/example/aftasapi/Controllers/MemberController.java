package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.DTOs.MemberDTO;
import com.example.aftasapi.Enums.IdentityDocumentType;
import com.example.aftasapi.Errors.ErrorMessageMember;
import com.example.aftasapi.Exceptions.MemberException;
import com.example.aftasapi.Requests.MemberRequest;
import com.example.aftasapi.Services.IMemberService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final IMemberService memberService ;
    private final ModelMapper modelMapper ;
    public MemberController(IMemberService memberService, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@Valid @RequestBody MemberRequest memberRequest){
        if (    memberRequest.getName().isEmpty()
                || memberRequest.getFamilyName().isEmpty()
                || memberRequest.getIdentityNumber().isEmpty()
                || memberRequest.getIdentityDocument() == null
                || memberRequest.getAccessionDate() == null ){
            throw new MemberException(ErrorMessageMember.MISSING_REQUIRED_FIELD.getErrorMessage());
        }



        MemberDTO memberDTO = memberService.create(modelMapper.map(memberRequest,MemberDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(memberDTO);
    }


    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers(){
        List<MemberDTO> members = memberService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }


    @GetMapping("{memberId}")
    public ResponseEntity<MemberDTO> getMember(@PathVariable long memberId){
        MemberDTO member = memberService.findById(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @PutMapping("{memberId}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable long memberId,@RequestBody MemberRequest memberRequest){
        MemberDTO memberUpdated = memberService.update(memberId,modelMapper.map(memberRequest,MemberDTO.class));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberUpdated);
    }

   @DeleteMapping("{memberId}")
   public ResponseEntity<?> deleteMember(@PathVariable long memberId){
       memberService.delete(memberId);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body("deleted");
   }




}
