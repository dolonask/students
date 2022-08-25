package kg.megacom.students.services;

import kg.megacom.students.models.Group;
import kg.megacom.students.models.requests.GroupRequest;

public interface GroupService {
    Group createGroup(Group group);

    Group create(GroupRequest groupRequest);
}
