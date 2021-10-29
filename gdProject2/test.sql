select * from subject order by name asc;
delete from subject;
drop sequence subject_seq;
create sequence subject_seq;
insert into subject values(subject_seq.nextval, '감염내과', '감염내과는 각종 미생물에 의한 감염병은 물론 원인을 모르는 열병(불명열) 환자, 에이즈, 결핵 환자 등을 진료하고 있습니다. 미생물에 의해 발생하는 모든 감염질환을 진단하고 치료하는 진료과입니다', '031-123-4560');
insert into subject values(subject_seq.nextval, '내분비대사내과', '내분비-대사 내과에서는 신체의 각종 내분비 기관에서 분비되어 나오는 호르몬의 이상이나 호르몬 분비 장기 또는 표적 장기의 각종 질병들을 진단 치료합니다.', '031-123-4561');
insert into subject values(subject_seq.nextval, '알레르기내과', '알레르기내과에서는 외부 물질에 대한 면역반응이 지나쳐서 과민반응을 일으키는 질환들을 진료하고 연구하는, 내과의 한 분과입니다. 특히 알레르기센터에 협조 진료합니다.', '031-123-4562');
insert into subject values(subject_seq.nextval, '성형외과', '성형외과에서는 분야별로 소이증 클리닉, 두개 안면 클리닉, 안면신경마비 클리닉, 흑색종 클리닉, 하지 족부 재건 클리닉, 혈관기형 클리닉, 레이져 클리닉 등 특성화된 전문 클리닉을 운영하고 있습니다.', '031-123-4563');
insert into subject values(subject_seq.nextval, '소아청소년과', '소아청소년과는 어린이와 청소년의 건강관리를 위한 3차 진료기관으로서 교육수련병원 그리고 연구기관의 면모를 갖추고 있습니다.', '031-123-4564');
insert into subject values(subject_seq.nextval, '안과', '안과는 연간 110,000명 이상의 외래 환자 진료와 6,000건에 달하는 수술을 시행하는 국내 최대 안과 병원으로서 최고의 의료진이 최상의 서비스를 제공 하고 있습니다.', '031-123-4565');
insert into subject values(subject_seq.nextval, '이비인후과', '염증과 관련된 급, 만성 중이염이나 삼출성 중이염염의 경우 수술적 치료가 필요할 수 있으며 현미경을 이용한 수술 방법부터 최근 내시경을 이용한 수술 방법까지 다양한 접근방법으로 시행하고 있습니다.', '031-123-4566');
insert into subject values(subject_seq.nextval, '정형외과', '사지와 척추에 있는 뼈와 관절 및 근육, 인대, 신경, 혈관 등 주위 조직에 대해서 연구하고, 질환과 외상을 진단하고 치료하는 분야입니다.', '031-123-4567');
insert into subject values(subject_seq.nextval, '피부과', '피부과는 피부 질환으로 고통 받는 많은 환자들을 위해 진료를 제공하고 있습니다. 각 전문과의 우수한 의료진과 첨단의 의료장비를 갖추었으며 우수한 전문의료인을 양성합니다.', '031-123-4568');
insert into subject values(subject_seq.nextval, '흉부외과', '흉부외과는 크게 심장외과와 폐,식도외과로 나누어져 있으며, 정확한 진단 및 치료를 시행하며, 최상의 서비스를 제공하기 위해 모든 의료진이 최선을 다하고 있습니다.', '031-123-4569');

/*
drop table patient cascade constraints;
drop table qna cascade constraints;
drop table reservation cascade constraints;
drop table doctor cascade constraints;
drop table comments cascade constraints;
drop table manager cascade constraints;
drop table subject cascade constraints;
drop table approval cascade constraints;
drop table notice cascade constraints;
drop table rest cascade constraints;
drop table files cascade constraints;
*/
/* 환자 회원 */
CREATE TABLE patient (
   pcode NUMBER NOT NULL, /* 회원 코드 */
   id VARCHAR(20), /* 아이디 */
   pw VARCHAR(20), /* 비밀번호 */
   nickname VARCHAR(20), /* 닉네임 */
   name VARCHAR(50), /* 이름 */
   tel VARCHAR(30), /* 연락처 */
   birth DATE, /* 생년월일 */
   gender VARCHAR(10), /* 성별 */
   email VARCHAR(40), /* 이메일 */
   postcode NUMBER, /* 우편번호 */
   address VARCHAR(255), /* 주소 */
   address2 VARCHAR(255) /* 상세주소 */
);

CREATE UNIQUE INDEX PK_patient
   ON patient (
      pcode ASC
   );

ALTER TABLE patient
   ADD
      CONSTRAINT PK_patient
      PRIMARY KEY (
         pcode
      );

/* 예약 */
CREATE TABLE reservation (
   rcode NUMBER NOT NULL, /* 예약 번호 */
   pcode NUMBER NOT NULL, /* 회원 코드 */
   dcode NUMBER NOT NULL, /* 의사 코드 */
   rsvdate DATE /* 예약 일자 */
);

CREATE UNIQUE INDEX PK_reservation
   ON reservation (
      rcode ASC
   );

ALTER TABLE reservation
   ADD
      CONSTRAINT PK_reservation
      PRIMARY KEY (
         rcode
      );

/* 소통 정보 */
CREATE TABLE qna (
   qno NUMBER NOT NULL, /* 게시글 번호 */
   pcode NUMBER NOT NULL, /* 회원 코드 */
   title VARCHAR(90), /* 제목 */
   content VARCHAR(900), /* 내용 */
   writedate DATE, /* 작성일자 */
   img VARCHAR(100), /* 사진 */
   cnt NUMBER /* 조회수 */
);

CREATE UNIQUE INDEX PK_qna
   ON qna (
      qno ASC
   );

ALTER TABLE qna
   ADD
      CONSTRAINT PK_qna
      PRIMARY KEY (
         qno
      );

/* 의사 */
CREATE TABLE doctor (
   dcode NUMBER NOT NULL, /* 의사 코드 */
   scode NUMBER NOT NULL, /* 과목 코드 */
   id VARCHAR(20), /* 아이디 */
   pw VARCHAR(20), /* 비밀번호 */
   name VARCHAR(50), /* 이름 */
   birth DATE, /* 생년월일 */
   licenseno NUMBER, /* 면허번호 */
   postcode NUMBER, /* 우편번호 */
   address VARCHAR(255), /* 주소 */
   address2 VARCHAR(255), /* 상세주소 */
   career VARCHAR(900), /* 경력사항 */
   tel VARCHAR(30), /* 연락처 */
   email VARCHAR(40) /* 이메일 */
);

CREATE UNIQUE INDEX PK_doctor
   ON doctor (
      dcode ASC
   );

ALTER TABLE doctor
   ADD
      CONSTRAINT PK_doctor
      PRIMARY KEY (
         dcode
      );

/* 진료 과목 */
CREATE TABLE subject (
   scode NUMBER NOT NULL, /* 과목 코드 */
   name VARCHAR(50), /* 과목 이름 */
   description VARCHAR(900), /* 과목 설명 */
   tel VARCHAR(30) /* 전화번호 */
);

CREATE UNIQUE INDEX PK_subject
   ON subject (
      scode ASC
   );

ALTER TABLE subject
   ADD
      CONSTRAINT PK_subject
      PRIMARY KEY (
         scode
      );

/* 관리자 */
CREATE TABLE manager (
   mcode NUMBER NOT NULL, /* 관리자 코드 */
   name VARCHAR(50), /* 관리자명 */
   id VARCHAR(20), /* 아이디 */
   pw VARCHAR(20) /* 비밀번호 */
);

CREATE UNIQUE INDEX PK_manager
   ON manager (
      mcode ASC
   );

ALTER TABLE manager
   ADD
      CONSTRAINT PK_manager
      PRIMARY KEY (
         mcode
      );

/* 공지사항 */
CREATE TABLE notice (
   ncode NUMBER NOT NULL, /* 게시글 번호 */
   mcode NUMBER NOT NULL, /* 관리자 코드 */
   title VARCHAR(90), /* 제목 */
   content VARCHAR(900), /* 내용 */
   writedate DATE, /* 작성일자 */
   cnt NUMBER /* 조회수 */
);

CREATE UNIQUE INDEX PK_notice
   ON notice (
      ncode ASC
   );

ALTER TABLE notice
   ADD
      CONSTRAINT PK_notice
      PRIMARY KEY (
         ncode
      );

/* 댓글 */
CREATE TABLE comments (
   qno NUMBER NOT NULL, /* 게시글 번호 */
   mcode NUMBER NOT NULL, /* 관리자 코드 */
   writedate DATE, /* 작성 일자 */
   content VARCHAR(150) /* 댓글 내용 */
);

CREATE UNIQUE INDEX PK_comments
   ON comments (
      qno ASC,
      mcode ASC
   );

ALTER TABLE comments
   ADD
      CONSTRAINT PK_comments
      PRIMARY KEY (
         qno,
         mcode
      );

/* 휴진 */
CREATE TABLE rest (
   rcode NUMBER NOT NULL, /* 휴진 번호 */
   acode NUMBER NOT NULL, /* 관리 번호 */
   restdate DATE, /* 휴진 날짜 */
   day VARCHAR(10) /* 휴진 요일 */
);

CREATE UNIQUE INDEX PK_rest
   ON rest (
      rcode ASC
   );

ALTER TABLE rest
   ADD
      CONSTRAINT PK_rest
      PRIMARY KEY (
         rcode
      );

/* 승인 신청 */
CREATE TABLE approval (
   acode NUMBER NOT NULL, /* 관리 번호 */
   dcode NUMBER NOT NULL, /* 의사 코드 */
   approvedate DATE, /* 신청 일자 */
   approved VARCHAR(10), /* 승인 여부 */
   reason VARCHAR(100) /* 휴진 사유 */
);

CREATE UNIQUE INDEX PK_approval
   ON approval (
      acode ASC
   );

ALTER TABLE approval
   ADD
      CONSTRAINT PK_approval
      PRIMARY KEY (
         acode
      );

/* 새 테이블2 */
CREATE TABLE files (
   fcode NUMBER NOT NULL, /* 새 컬럼 */
   ncode NUMBER NOT NULL, /* 게시글 번호 */
   uploaddate DATE, /* 새 컬럼3 */
   name VARCHAR(100), /* 새 컬럼4 */
   beforename VARCHAR(100), /* 새 컬럼5 */
   filesize NUMBER /* 새 컬럼6 */
);

CREATE UNIQUE INDEX PK_files
   ON files (
      fcode ASC
   );

ALTER TABLE files
   ADD
      CONSTRAINT PK_files
      PRIMARY KEY (
         fcode
      );

ALTER TABLE reservation
   ADD
      CONSTRAINT FK_patient_TO_reservation
      FOREIGN KEY (
         pcode
      )
      REFERENCES patient (
         pcode
      );

ALTER TABLE reservation
   ADD
      CONSTRAINT FK_doctor_TO_reservation
      FOREIGN KEY (
         dcode
      )
      REFERENCES doctor (
         dcode
      );

ALTER TABLE qna
   ADD
      CONSTRAINT FK_patient_TO_qna
      FOREIGN KEY (
         pcode
      )
      REFERENCES patient (
         pcode
      );

ALTER TABLE doctor
   ADD
      CONSTRAINT FK_subject_TO_doctor
      FOREIGN KEY (
         scode
      )
      REFERENCES subject (
         scode
      );

ALTER TABLE notice
   ADD
      CONSTRAINT FK_manager_TO_notice
      FOREIGN KEY (
         mcode
      )
      REFERENCES manager (
         mcode
      );

ALTER TABLE comments
   ADD
      CONSTRAINT FK_qna_TO_comments
      FOREIGN KEY (
         qno
      )
      REFERENCES qna (
         qno
      );

ALTER TABLE comments
   ADD
      CONSTRAINT FK_manager_TO_comments
      FOREIGN KEY (
         mcode
      )
      REFERENCES manager (
         mcode
      );

ALTER TABLE rest
   ADD
      CONSTRAINT FK_approval_TO_rest
      FOREIGN KEY (
         acode
      )
      REFERENCES approval (
         acode
      );

ALTER TABLE approval
   ADD
      CONSTRAINT FK_doctor_TO_approval
      FOREIGN KEY (
         dcode
      )
      REFERENCES doctor (
         dcode
      );

ALTER TABLE files
   ADD
      CONSTRAINT FK_notice_TO_files
      FOREIGN KEY (
         ncode
      )
      REFERENCES notice (
         ncode
      );
-- 데이터 삽입      
select * from patient;
select * from subject;
select * from manager;
select * from qna;

select * from manager;
insert into manager (mcode, name, id, pw)
   values (1, '매니저1', 'manager1', '1234');
insert into manager (mcode, name, id, pw)
   values (2, '매니저2', 'manager2', '123123');
insert into manager (mcode, name, id, pw)
   values (3, '매니저3', 'manager3', '4321');
insert into manager (mcode, name, id, pw)
   values (4, '매니저4', 'manager4', 'm1234');
insert into manager (mcode, name, id, pw)
   values (5, '매니저5', 'manager5', '1234m');

select * from subject; 
insert into subject values(1, '가가가과', '국가안전보장에 관련되는 대외정책·군사정책과 국내정책의 수립에 관하여 국무회의의 심의에 앞서 대통령의 자문에 응하기 위하여 국가안전보장회의를 둔다.', '031-123-4567');
insert into subject values(2, '나나나과', '행정각부의 장은 국무위원 중에서 국무총리의 제청으로 대통령이 임명한다. 대통령이 제1항의 기간내에 공포나 재의의 요구를 하지 아니한 때에도 그 법률안은 법률로서 확정된다.', '031-456-7890');
insert into subject values(3, '다다다과', '국가는 농업 및 어업을 보호·육성하기 위하여 농·어촌종합개발과 그 지원등 필요한 계획을 수립·시행하여야 한다. 대법관의 임기는 6년으로 하며, 법률이 정하는 바에 의하여 연임할 수 있다.', '031-321-7654');
insert into subject values(4, '라라라과', '공무원의 신분과 정치적 중립성은 법률이 정하는 바에 의하여 보장된다. 국회는 법률에 저촉되지 아니하는 범위안에서 의사와 내부규율에 관한 규칙을 제정할 수 있다.', '031-987-6543');
insert into subject values(5, '마마마과', '누구든지 병역의무의 이행으로 인하여 불이익한 처우를 받지 아니한다. 혼인과 가족생활은 개인의 존엄과 양성의 평등을 기초로 성립되고 유지되어야 하며, 국가는 이를 보장한다.', '031-876-5432');

select * from patient;
insert into PATIENT values (1, 'aaa1234', '1234', '환자1', '홍길동', '010-1111-1111', to_date('1997-10-18','yyyy-mm-dd'), '남', 'pa123@sample.com', 12345, '경기도', '광명시');
insert into PATIENT values (2, 'bbb1234', '1234', '환자2', '스폰지밥', '010-2345-1111', to_date('1992-2-3','yyyy-mm-dd'), '여', 'sdf@sample.com', 2222, '서울특별시', '구로구');
insert into PATIENT values (3, 'ccc1234', '1234', '환자3', '징징이', '010-1111-1235', to_date('1991-11-21','yyyy-mm-dd'), '여', 'asdf@sample.com', 33333, '충청남도', '공주시');
insert into PATIENT values (4, 'ddd1234', '1234', '환자4', '뚱이', '010-2523-1123', to_date('1996-3-14','yyyy-mm-dd'), '남', 'gsds@sample.com', 44444, '강원도', '삼척시');
insert into PATIENT values (5, 'eee1234', '1234', '환자5', '다람이', '010-6434-1231', to_date('1999-6-26','yyyy-mm-dd'), '남', 'adfas@sample.com', 55555, '서울특별시', '종로구');
insert into PATIENT values(6,'id6','6666','닉네임6','이름6','010-1111-1116',to_date('1992-6-19','yyyy-mm-dd'),'남','email6@email.com','66666','주소6','세부주소6');
insert into PATIENT values(7,'id7','7777','닉네임7','이름7','010-1111-1117',to_date('1993-5-18','yyyy-mm-dd'),'여','email7@email.com','77777','주소7','세부주소7');
insert into PATIENT values(8,'id8','8888','닉네임8','이름8','010-1111-1118',to_date('1994-4-17','yyyy-mm-dd'),'남','email8@email.com','88888','주소8','세부주소8');
insert into PATIENT values(9,'id9','9999','닉네임9','이름9','010-1111-1119',to_date('1995-3-16','yyyy-mm-dd'),'여','email9@email.com','99999','주소9','세부주소9');
insert into PATIENT values(10,'id10','0000','닉네임10','이름10','010-1111-1110',to_date('1996-2-15','yyyy-mm-dd'),'남','email10@email.com','10000','주소10','세부주소10');

select * from doctor;
insert into doctor values(1, 1, 'id1', 'pw1', '의사1', to_date('1992-6-19','yyyy-mm-dd'), 12345678, 12345, '주소1', '상세주소1', '경력1', '010-1234-5678', 'abcd@abcd.com');
insert into doctor values(2, 1, 'id2', 'pw2', '의사2', to_date('1992-7-19','yyyy-mm-dd'), 23456789, 23456, '주소2', '상세주소2', '경력2', '010-2345-6789', 'bcde@bcde.com');
insert into doctor values(3, 3, 'id3', 'pw3', '의사3', to_date('1992-2-13','yyyy-mm-dd'), 34567890, 34567, '주소3', '상세주소3', '경력3', '010-3456-7890', 'cdef@cdef.com');
insert into doctor values(4, 4, 'id4', 'pw4', '의사4', to_date('1991-4-19','yyyy-mm-dd'), 45678901, 45678, '주소4', '상세주소4', '경력4', '010-4567-8901', 'defg@defg.com');
insert into doctor values(5, 5, 'id5', 'pw5', '의사5', to_date('1991-5-13','yyyy-mm-dd'), 56789012, 56789, '주소5', '상세주소5', '경력5', '010-5678-9012', 'efgh@efgh.com');

select * from notice;
insert into notice values (001, 1, '공지사항1', '1번 공지사항입니다.', to_date('2021-01-01','yyyy-mm-dd'), 0);
insert into notice values (002, 2, '공지사항2', '2번 공지사항입니다.', to_date('2021-02-01','yyyy-mm-dd'), 0);
insert into notice values (003, 3, '공지사항3', '3번 공지사항입니다.', to_date('2021-03-01','yyyy-mm-dd'), 0);
insert into notice values (004, 4, '공지사항4', '4번 공지사항입니다.', to_date('2021-04-01','yyyy-mm-dd'), 0);
insert into notice values (005, 5, '공지사항5', '5번 공지사항입니다.', to_date('2021-05-01','yyyy-mm-dd'), 0);

select * from qna;
insert into qna values (1, 1, '질문1', '질문일번입니다', sysdate, 'image경로1', 0);
insert into qna values (2, 3, '질문2', '질문이번입니다', sysdate, 'image경로2', 1);
insert into qna values (3, 5, '질문3', '질문삼번입니다', sysdate, 'image경로3', 727777);
insert into qna values (4, 7, '질문4', '질문사번입니다', sysdate, 'image경로4', 1000);
insert into qna values (5, 9, '질문5', '질문오번입니다', sysdate, 'image경로5', 55555);

select * from reservation;
insert into reservation values(1, 1, 2, to_date('2021-03-12','yyyy-mm-dd'));
insert into reservation values(2, 2, 1, to_date('2021-12-21','yyyy-mm-dd'));
insert into reservation values(3, 3, 5, to_date('2021-05-13','yyyy-mm-dd'));
insert into reservation values(4, 4, 4, to_date('2021-04-09','yyyy-mm-dd'));
insert into reservation values(5, 5, 3, to_date('2021-03-03','yyyy-mm-dd'));

select * from comments;
insert into COMMENTS values(1,1,to_date('2021-10-20','yyyy-mm-dd'),'감사합니다1');
insert into COMMENTS values(2,2,to_date('2021-09-20','yyyy-mm-dd'),'감사합니다2');
insert into COMMENTS values(3,3,to_date('2021-08-20','yyyy-mm-dd'),'감사합니다3');
insert into COMMENTS values(4,4,to_date('2021-07-20','yyyy-mm-dd'),'감사합니다4');
insert into COMMENTS values(5,5,to_date('2021-06-20','yyyy-mm-dd'),'감사합니다5');

select * from files;
insert into files values(1,1, to_date('2021-01-23', 'yyyy-mm-dd'), '바뀐이름1', '원래이름1', 3);
insert into files values(2,2, to_date('2021-02-23', 'yyyy-mm-dd'), '바뀐이름2', '원래이름2', 2);
insert into files values(3,3, to_date('2021-03-23', 'yyyy-mm-dd'), '바뀐이름3', '원래이름3', 1);
insert into files values(4,4, to_date('2021-04-23', 'yyyy-mm-dd'), '바뀐이름4', '원래이름4', 3);
insert into files values(5,5, to_date('2021-05-23', 'yyyy-mm-dd'), '바뀐이름5', '원래이름5', 2);



select * from approval;
insert into approval values (1, 5, sysdate, '승인', '병가');
insert into approval values (2, 4, sysdate, '대기', '휴가');
insert into approval values (3, 3, sysdate, '대기', '휴가');
insert into approval values (4, 2, sysdate, '대기', '휴가');
insert into approval values (5, 1, sysdate, '거절', '꾀병');

select * from rest;
insert into rest values(1, 1, null, 'FRI');
insert into rest values(2, 2, to_date('2021-03-12','yyyy-mm-dd'), null);
insert into rest values(3, 4, null, 'WED');
insert into rest values(4, 4, to_date('2021-03-15','yyyy-mm-dd'), null);
insert into rest values(5, 5, null, 'MON');

SELECT COUNT(*) FROM PATIENT WHERE ID='id6';

SELECT * FROM ((RESERVATION NATURAL JOIN PATIENT) NATURAL JOIN SUBJECT)NATURAL JOIN DOCTOR WHERE RCODE=2; 

SELECT a.name, a.tel, b.rsvdate, c.name, d.name FROM patient a INNER JOIN reservation b
ON a.pcode = b.pcode
INNER JOIN doctor c
ON b.dcode = c.dcode
INNER JOIN subject d
ON c.scode = d.scode
WHERE a.pcode = 1;

alter table reservation add state varchar(10);

insert into reservation values(6, 5, 3, to_date('2021-03-03','yyyy-mm-dd'), '예약');


select rcode,rsvdate, ds.name, state from (select d.dcode, d.scode, s.name from doctor d join subject s on d.scode = s.scode) ds join reservation r
on r.dcode = ds.dcode where pcode=1;

SELECT a.id
  , b.rcode
    , b.rsvdate
    , c.name
    , d.name
 FROM patient a
INNER JOIN reservation b
   ON a.pcode = b.pcode
INNER JOIN doctor c
   ON b.dcode = c.dcode
   INNER JOIN subject d
   ON c.scode = d.scode
WHERE a.pcode = '1';


select d.name,s.name,d.career from doctor d join subject s on d.scode = s.scode where d.dcode = 1;

select q.qno, q.title, p.nickname, q.writedate, q.cnt
from qna q inner join patient p
on q.pcode = p.pcode;

select q.qno, q.title, q.content, p.nickname, q.writedate, q.cnt from qna q join patient p
on q.pcode = p.pcode where p.pcode= 1;

select * from comments where qno = 1;

update qna set title = 'qna001', content = '내용11', img = '경로11'  where qno = 1 and pcode = 1;

select rcode, rsvdate, ds.name, state from (select d.dcode, d.scode, s.name from doctor d join subject s
on d.scode = s.scode) ds join reservation r
on r.dcode = ds.dcode where ds.dcode=1;

SELECT b.rcode
    , b.rsvdate
    , a.name
 FROM patient a
INNER JOIN reservation b
   ON a.pcode = b.pcode
INNER JOIN doctor c
   ON b.dcode = c.dcode
WHERE c.dcode = '1';

select d.dcode, d.name, s.name, d.licenseno from doctor d join subject s
on d.scode = s.scode
Where s.scode = 1;

select a.acode,d.name, a.approvedate, a.approved from doctor d inner join approval a
on d.dcode = a.dcode;

select a.acode, d.name, a.approvedate, a.approved 
from doctor d inner join approval a
on d.dcode = a.dcode where d.name like '%의사%'
order by a.acode desc;

select d.name, a.approvedate, a.approved, a.reason 
from doctor d inner join approval a
on d.dcode = a.dcode
where acode = 1;

update approval set approved = '승인' where acode = 1;

select n.ncode, n.title, m.name, n.writedate, n.cnt
from notice n inner join manager m
on n.mcode = m.mcode
order by n.ncode desc;


select n.ncode, n.title, m.name, n.writedate, n.cnt
from notice n inner join manager m
on n.mcode = m.mcode
where n.title like '%입니다%' or n.content like '%입니다%'
order by n.ncode desc;

select q.qno, q.title, p.nickname, q.writedate, q.cnt 
from qna q join patient p
on q.pcode = p.pcode 
where p.nickname like '%환자%'
order by q.qno desc;

select q.qno, q.title, p.nickname, q.writedate, q.cnt 
from qna q join patient p
on q.pcode = p.pcode 
where q.title like '%질문%' or q.content like '%질문%'
order by q.qno desc;

--///////////////////////////////////////////////////////
insert into PATIENT values (1, 'aaa1234', '1234', '환자1’, '홍길동', '010-1111-1111', to_date('1997-10-18','yyyy-mm-dd'), '남’, 'pa123@sample.com', 12345, '경기도', '광명시');

select count(*) from patient where id = 'aaa1234';

select id, pw from patient where id ='aaa1234' and pw = '1234';

select id, pw from doctor where id = 'id1' and pw = 'pw1';

select id, pw from manager where id = 'manager1' and pw = '1234';

update patient set pw = '1111', postcode = 00000, address = '대전', address2 = '유성구', tel = '010-1234-5678', email = 'sample1@samp.com' where pcode = 1;

select * from patient where pcode = 1;


select n.ncode, n.title, m.name, n.writedate, n.cnt
from notice n inner join manager m
on n.mcode = m.mcode
order by n.ncode desc;


select n.ncode, n.title, m.name, n.writedate, n.cnt
from notice n inner join manager m
on n.mcode = m.mcode
where n.title like '%입니다%' or n.content like '%입니다%'
order by n.ncode desc;


select n.title, m.name, n.writedate, n.cnt, n.content
from notice n inner join manager m
on n.mcode = m.mcode
where ncode=1;

select beforename from files where ncode=1;

update files set uploaddate=sysdate, name='바뀐이름6', beforename='원래이름6', filesize=3 where fcode=1;
select * from files;
delete from files;

delete from files where ncode=1;


alter table files drop constraint fk_notice_to_files;
alter table files add constraint fk_notice_to_files 
foreign key (ncode) references notice(ncode) on delete cascade;




SELECT TABLE_NAME, CONSTRAINT_NAME 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'QNA';

SELECT TABLE_NAME, CONSTRAINT_NAME 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'COMMENTS';

SELECT TABLE_NAME, CONSTRAINT_NAME 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'RESERVATION';

SELECT TABLE_NAME, CONSTRAINT_NAME 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'APPROVAL';

SELECT TABLE_NAME, CONSTRAINT_NAME 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'REST';

alter table qna drop constraint FK_patient_TO_qna;
alter table qna add constraint FK_patient_TO_qna 
foreign key (pcode) references patient(pcode) on delete cascade;

alter table reservation drop constraint FK_patient_TO_reservation;
alter table reservation add constraint FK_patient_TO_reservation 
foreign key (pcode) references patient(pcode) on delete cascade;

alter table reservation drop constraint FK_doctor_TO_reservation;
alter table reservation add constraint FK_doctor_TO_reservation 
foreign key (dcode) references doctor(dcode) on delete cascade;

alter table comments drop constraint FK_qna_TO_comments;
alter table comments add constraint FK_qna_TO_comments 
foreign key (qno) references qna(qno) on delete cascade;

alter table APPROVAL drop constraint FK_doctor_TO_approval;
alter table APPROVAL add constraint FK_doctor_TO_approval 
foreign key (dcode) references doctor(dcode) on delete cascade;

alter table rest drop constraint FK_APPROVAL_TO_REST;
alter table rest add constraint FK_APPROVAL_TO_REST 
foreign key (acode) references approval(acode) on delete cascade;

delete from patient where pcode=1;
select * from reservation;
create sequence rsv_seq;
create sequence pcode;
drop sequence pcode;
delete from patient;
select * from patient;
select * from rest;
create sequence approval_seq;
drop sequence approval_seq;
select * from notice;
select * from manager;
delete from approval;
insert into approval values (approval_seq.nextval, 10, to_date('2021-11-01', 'yyyy-mm-dd'), '대기', '휴가', sysdate);
insert into approval values (approval_seq.nextval, 5, to_date('2021-11-03', 'yyyy-mm-dd'), '대기', '개인사유', sysdate);
ALTER TABLE approval ADD requestdate DATE;
alter table approval drop column adate;
ALTER TABLE approval DROP COLUMN requestdate;

drop table rest;
drop table approval;

alter table approval add restdate date;
alter table approval add day varchar(10);


insert into approval values (1, 5, sysdate, '승인', '병가', null, 'FRI');
insert into approval values (2, 4, sysdate, '대기', '휴가', to_date('2021-03-12','yyyy-mm-dd'), null);
insert into approval values (3, 3, sysdate, '대기', '휴가', null, 'WED');
insert into approval values (4, 2, sysdate, '대기', '휴가', to_date('2021-03-15','yyyy-mm-dd'), null);
insert into approval values (5, 1, sysdate, '거절', '꾀병', null, 'MON');

alter table approval rename to rest;
alter table rest rename column acode to rcode;
alter table rest rename column approvedate to requestdate;
select * from rest;
create sequence rest_seq;
delete from rest;
insert into rest values (rest_seq.nextval, 3, sysdate, '대기', '병가', to_date('2021-11-03', 'yyyy-mm-dd'), null);
insert into rest values (rest_seq.nextval, 3, sysdate, '대기', '휴진', null, 'FRI');
select * from rest where dcode = 3;
select * from rest where approved = '대기' and dcode = 3;
select rcode, dcode, requestdate, approved, reason, to_char(restdate, 'yyyy-mm-dd')as restdate, day from rest where approved = '승인' and dcode = 3;
update rest set approved = '승인' where dcode = 12;
