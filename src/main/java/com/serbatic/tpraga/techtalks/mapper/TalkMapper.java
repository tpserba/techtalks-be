package com.serbatic.tpraga.techtalks.mapper;

import com.serbatic.tpraga.techtalks.dto.TalkDto;
import com.serbatic.tpraga.techtalks.model.Talk;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TalkMapper {

    Talk talkDtoToTalk(TalkDto talkDto);

    TalkDto TalkToTalkDto(Talk talk);
}
