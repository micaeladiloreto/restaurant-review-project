package org.wecancodeit.reviews.reposandstorage;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.pojos.Hashtag;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    public Hashtag findHashtagByHashName(String hashName);
}
