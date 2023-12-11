package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.MemberDTO;
import com.example.aftasapi.Entities.MemberEntity;
import com.example.aftasapi.Repositories.MemberRepository;
import com.example.aftasapi.Services.IMemberService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {

   private final MemberRepository memberRepository ;
    private final ModelMapper modelMapper;

    public MemberServiceImpl(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MemberDTO create(MemberDTO memberDTO) {
        MemberEntity member = modelMapper.map(memberDTO,MemberEntity.class);
        MemberEntity memberCreated ;
        try{
            memberCreated = memberRepository.save(member);
        }catch(Exception ex){
            throw new RuntimeException("Error saving competition : ", ex);
        }
        // log
        MemberDTO memberDTOCreated = modelMapper.map(memberCreated,MemberDTO.class);
        return memberDTOCreated;
    }

    @Override
    public MemberDTO update(long competition_id, MemberDTO memberDTO) {
        return null;
    }

    @Override
    public MemberDTO findMemberById(long id) {
        return null;
    }

    @Override
    public void delete(MemberDTO memberDTO) {

    }

    @Override
    public List<MemberDTO> findAll() {
        return null;
    }
}
