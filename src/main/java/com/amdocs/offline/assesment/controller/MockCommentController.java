package com.amdocs.offline.assesment.controller;

import com.amdocs.offline.assesment.mockcomment.entity.Comment;
import com.amdocs.offline.assesment.mockcomment.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/** @author <a href  swati.gbpant@gmail.com</>**/

@RestController
@RequestMapping("/mockcomment")
public class MockCommentController {


    @PostMapping("/createnewuser")
    public void createUser(@RequestBody Person person){

    }

    @PostMapping("/createcomment")
    public void createComment(@RequestHeader Person person,@RequestBody String message){
        // Depend on person role object will be instantiated and comment will be created
    }

    @GetMapping("/lastlogin")
    public LocalDateTime getLastLogin(@RequestHeader Person person){
        return person.getLastLoggedInTime();
    }

    @GetMapping("/privilege")
    public void editOrDeleteprivilege(@RequestHeader Person person,@RequestParam Comment comment) {
            //Person object contains role info which will help to map the instance to moderator , admin or User and thus knowing the privilege
    }

    @GetMapping("/originalcomment")
    public Comment originalComment(@RequestHeader Comment comment)
    {
        // Considering only positive senario
       return comment.getRepliedTo();
    }

   }
