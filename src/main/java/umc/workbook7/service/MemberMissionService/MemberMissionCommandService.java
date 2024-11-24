package umc.workbook7.service.MemberMissionService;

import umc.workbook7.domain.entity.mapping.MemberMission;
import umc.workbook7.web.dto.MemberMission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission createMemberMission(Long missionId, MemberMissionRequestDTO.CreateMemberMissionRequestDTO request);
}
