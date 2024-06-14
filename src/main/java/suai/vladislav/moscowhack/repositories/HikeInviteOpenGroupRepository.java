package suai.vladislav.moscowhack.repositories;

import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.hike.HikeInvite;
import suai.vladislav.moscowhack.requests.HikeInviteOpenGroup;

public interface HikeInviteOpenGroupRepository extends CrudRepository<HikeInvite, Integer> {
}
