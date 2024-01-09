package com.resume.domain.response;

import com.resume.domain.entity.Resume;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
public class ResumeListResponseDto implements ResponseDto {
    private final List<ResumeResponseDto> resumeResponseDto;

    public ResumeListResponseDto(List<Resume> resumeList) {
        this.resumeResponseDto = resumeList.stream().map(ResumeResponseDto::new).collect(Collectors.toList());
    }
}
