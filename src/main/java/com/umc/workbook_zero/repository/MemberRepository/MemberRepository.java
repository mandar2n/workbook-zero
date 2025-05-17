package com.umc.workbook_zero.repository.MemberRepository;

import com.umc.workbook_zero.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
