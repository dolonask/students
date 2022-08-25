package kg.megacom.students.controllers;

import kg.megacom.students.models.Group;
import kg.megacom.students.models.requests.GroupRequest;
import kg.megacom.students.services.GroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/group")
public class GroupController {


    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/createGroup")
    public Group createGroup(@RequestBody Group group){
        return groupService.createGroup(group);
    }

    @PostMapping("/create")
    public Group create(@RequestBody GroupRequest groupRequest){
        return groupService.create(groupRequest);
    }

}
