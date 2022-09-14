package com.example.PCandra.mapper;

import com.example.PCandra.dtos.PollDto;
import com.example.PCandra.entity.Poll;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class PollMapper {

    public static Poll toEntity(PollDto pollDto){
        Poll poll = new Poll();

        poll.setQuestion(pollDto.getQuestion());
        poll.setTopic(pollDto.getTopic());
        poll.setKeywords(pollDto.getKeywords());
        poll.setExpirationDate(pollDto.getExpirationDate());
        return poll;
    }

    public static PollDto toDto(Poll poll){
        PollDto pollDto = new PollDto();
        pollDto.setId(poll.getId());
        pollDto.setQuestion(poll.getQuestion());
        pollDto.setTopic(poll.getTopic());
        pollDto.setActive(poll.getActive());
        pollDto.setCreationDate(poll.getCreationDate());
        pollDto.setExpirationDate(poll.getExpirationDate());
        return pollDto;
    }


    public static List<PollDto> toListDto(List<Poll> pools){
       List<PollDto> poolDtos=new ArrayList<>();
       Iterator<Poll> it = pools.iterator();
       while(it.hasNext()){
           PollDto poll = PollMapper.toDto(it.next());
           poolDtos.add(poll);
       }
       return poolDtos;

    }


    public static Page<PollDto> toPageDto(Page<Poll> entities) {
        Page<PollDto> dtoPage = entities.map(new Function<Poll, PollDto>() {
            @Override
            public PollDto apply(Poll entity) {
                PollDto dto = PollMapper.toDto(entity);
                return dto;
            }
        });
        return dtoPage;
    }
}


