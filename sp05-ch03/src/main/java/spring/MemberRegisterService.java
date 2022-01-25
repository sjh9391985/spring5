package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	private MemberDao memberDao;

	// 의존하는 객체를 직접 생성하는 대신 의존 객체를 전달받는 방식을 사용합니다.
	// 의존객체를 직접 생성하지 않는 코드입니다.
	// MemberDao 객체를 직접 주입받는 코드입니다.
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), 
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
