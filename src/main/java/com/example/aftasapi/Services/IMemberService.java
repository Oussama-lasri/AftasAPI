package com.example.aftasapi.Services;

import com.example.aftasapi.DTOs.MemberDTO;

import java.util.List;

public interface IMemberService {
    public MemberDTO create(MemberDTO memberDTO);
    public MemberDTO update(long id,MemberDTO memberDTO);
    public MemberDTO findMemberById(long id);
    public void delete(MemberDTO memberDTO);
    public List<MemberDTO> findAll();
}
