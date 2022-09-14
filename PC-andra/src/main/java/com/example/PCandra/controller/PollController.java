package com.example.PCandra.controller;

import com.example.PCandra.dtos.PollDto;
import com.example.PCandra.entity.Poll;
import com.example.PCandra.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PollController {
    @Autowired
    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping(path = "/allPolls")
    public List<PollDto> getAllPools(){
        return pollService.getAllPools();
    }

    @GetMapping(value = "/allPoolsByTopic")
    public List<PollDto> getAllPoolsByTopic(@RequestParam String topic){
        return pollService.getAllPoolsByTopic(topic);
    }

    @GetMapping("/sortingby/{field}")
        public List<PollDto> getPoolsWithSort(@PathVariable String field){
        return pollService.findPollWithSorting(field);

    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<PollDto> getPoolsWithPagination(@PathVariable int offset,@PathVariable int pageSize){
        return pollService.findPoolsWithPagination(offset,pageSize);

    }

    @PostMapping(value = "/newPoll")
    public ResponseEntity<PollDto> addPoll(@RequestBody PollDto pollDto){
         PollDto addedPollDto = pollService.addPoll(pollDto);
         return ResponseEntity.status(HttpStatus.CREATED).body(addedPollDto);
    }

    @GetMapping("/paginationandsort/{offset}/{pageSize}/{field}")
    public Page<PollDto> getUserChoiseWithPaginationandSorting(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field){
        return pollService.findPoolsWithPaginationAndSorting(offset,pageSize,field);
    }

   @GetMapping( "/activesPolls/{offset}")
   public List<PollDto> getAllActivesPolls(@PathVariable int offset){
        return pollService.getActivesPolls(offset);
   }
}
