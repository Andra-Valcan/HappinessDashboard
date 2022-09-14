package com.example.PCandra.service;

import com.example.PCandra.dtos.PollDto;
import com.example.PCandra.entity.Poll;
import com.example.PCandra.exception.CustomException;
import com.example.PCandra.mapper.PollMapper;
import com.example.PCandra.repository.PollRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PollService {
    private final PollRepository pollRepository;


    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }



    public List<PollDto> getAllPools() {
        List<Poll> pools = pollRepository.findAll();
        return PollMapper.toListDto(pools);
    }


    public List<PollDto> getAllPoolsByTopic(String topic) {
        List<Poll> polls = pollRepository.findByTopic(topic);
        return PollMapper.toListDto(polls);
    }

    public List<PollDto> findPollWithSorting(String field){
        List<Poll> polls = pollRepository.findAll(Sort.by(Sort.Direction.ASC, field));
        return PollMapper.toListDto(polls);
    }

    public Page<PollDto> findPoolsWithPagination(int offset,int pageSize){
        Page<Poll> pools = pollRepository.findAll(PageRequest.of(offset,pageSize));


        return PollMapper.toPageDto(pools);
    }

    public Page<PollDto> findPoolsWithPaginationAndSorting(int offset,int pageSize,String field){
        Page<Poll> pools = pollRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
        return PollMapper.toPageDto(pools);
    }

    public PollDto addPoll(PollDto pollDto) {
        System.out.println(pollDto.getExpirationDate());
        System.out.println(pollDto.getQuestion());
        System.out.println(pollDto.getTopic());
        if(pollDto.getId()!=null) throw new CustomException(HttpStatus.EXPECTATION_FAILED,"New request should not have an ID");
        Poll poll = PollMapper.toEntity(pollDto);
        Poll savedPoll = pollRepository.save(poll);
        PollDto newPollDto=PollMapper.toDto(savedPoll);
        return newPollDto;
    }


    public List<PollDto> getActivesPolls(int offset) {
       List<Poll> p =  pollRepository.findAllActivePolls(offset);
       return PollMapper.toListDto(p);
    }
}
