insert into PATIENT values (pcode.nextval, ?, ?, ?,?,?, to_date(?,'yyyy-mm-dd'),?,?,?,?,?)

create sequence pcode;

drop sequence pcode;



delete from patient where pcode = ?


select count(*) from patient where id = ?


select id, pw from patient where id =? and pw = ?

--진료과
create sequence subject_seq;
select * from subject;
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

select id, pw from doctor where id =? and pw =?
create sequence doctor_seq;
select * from doctor;
delete from doctor;

insert into doctor values(doctor_seq.nextval, 1, 'dknv1234', 'skng9710s', '이철진', to_date('1971-6-19','yyyy-mm-dd'), 797202, 12345, '서울특별시', '구로구', '1997~2002 구디병원 홍보실 실장, 2002~2007 구디병원 폐연구소장, 2007~2010 구디병원 중환자 진료부장, 2010~2014 구디병원 감염내과 과장, 2015~현재 구디병원 내과 주임교수', '010-2325-5145', 'abcd@gdhp.com');
insert into doctor values(doctor_seq.nextval, 2, 'cmen0173', 'dkng0982', '최근수', to_date('1984-8-23','yyyy-mm-dd'), 298273, 08623, '경기도', '파주시', '2011~2015 구디병원 내분비대사내과 주임교수 및 임상과장, 2009~2015 구디병원 의학유전학과장, 2015~2016 대한골다공증학회 회장, 2016~현재 구디병원 노인보건연구센터 소장', '010-9374-2074', 'qert@gdhp.com');
insert into doctor values(doctor_seq.nextval, 3, 'aknasf82', 'asong832', '박진웅', to_date('1972-1-27','yyyy-mm-dd'), 973623, 28616, '서울특별시', '양천구', '1997~2002 구디병원 지역의약품안전센터 센터장 역임, 2002~2007 구디병원 첨단의학연구원장 역임, 2007~2010 구디병원 의학연구협력센터장 역임, 2010~현재 구디병원 의료원장', '010-3972-7718', 'qtw34@gdhp.com');
insert into doctor values(doctor_seq.nextval, 4, 'sang92311', 'asmng9782', '전예원', to_date('1968-3-13','yyyy-mm-dd'), 493829, 39726, '서울특별시', '마포구', '2000~2008 구디병원 성형외과 임상강사, 2008~2014 구디병원 성형외과 조교수, 2014~현재 구디병원 성형외과 부교수', '010-1297-1723', '12rtwe@gdhp.com');
insert into doctor values(doctor_seq.nextval, 5, 'slmgn9872', 'lamgio3972', '이가윤', to_date('1971-9-9','yyyy-mm-dd'), 382034, 29712, '서울특별시', '영등포구', '1997~2002 구디병원 조혈모세포이식 및 소아암 센터장, 2007~2009 구디병원 홍보실장, 2009~2014 구디병원 소아청소년과 교수, 2014~현재 구디병원 커뮤니케이션실장', '010-1974-2193', 'wtgqw@gdhp.com');
insert into doctor values(doctor_seq.nextval, 6, 'aknavsd732', 'bkne372', '김이준', to_date('1967-5-12','yyyy-mm-dd'), 292836, 12384, '수원광역시', '영통구', '1995~2007 구디병원 안과 부교수, 2007~2010 국민연금공단 자문위원, 2010~2014 보건복지부 장애판정위원회 위원, 2015~현재 구디병원 진료운영실장', '010-1084-1649', 'sh3867@gdhp.com');
insert into doctor values(doctor_seq.nextval, 7, 'sas27847', 'aigj34972', '진선정', to_date('1976-12-29','yyyy-mm-dd'), 978232, 29757, '경기도', '성남시', '1996~2007 구디병원 이비인후과 의국장, 2009~현재 구디병원 이비인후과 교수, 2013~현재 구디병원 입원부장', '010-5072-1975', 'bmo2791@gdhp.com');
insert into doctor values(doctor_seq.nextval, 8, 'kwoopd98', 'angi732', '강준', to_date('1987-10-12','yyyy-mm-dd'), 079532, 29875, '서울특별시', '성동구', '2007~2010 구디병원 정형외과 교수, 2010~현재 구디병원 정형외과 전문의', '010-3683-0287', 'dknvi772@gdhp.com');
insert into doctor values(doctor_seq.nextval, 9, 'lsmo081243', 'ahig48271', '채지수', to_date('1985-7-27','yyyy-mm-dd'), 093621, 38671, '서울특별시', '마포구', '2003~2007 구디병원 피부과 전임의, 2007~2010 구디병원 피부과 임상조교수, 2010~2014 구디병원 피부과 부교수, 2015~2018 구디병원 피부과 교수, 2018~현재 구디병원 피부과 과장', '010-9716-1686', 'ci7t61@gdhp.com');
insert into doctor values(doctor_seq.nextval, 10, 's0ujg08', 'ainiey827', '석수민', to_date('1983-2-14','yyyy-mm-dd'), 325234, 14287, '경기도', '광명시', ' 2005~2007 구디병원 흉부외과 전문의, 2007~2010 구디병원 환자중심 삶의 질 연구소 소장, 2010~현재 구디병원 암센터장', '010-0273-1927', 'smoie712@gdhp.com');

select id, pw from manager where id =? and pw =?

select n.ncode, n.title, m.name, n.writedate, n.cnt from notice n inner join manager m on n.mcode = m.mcode where n.title like ? or n.content like ? order by n.ncode desc

insert into notice values (ncode.nextval, ?, ?, ?, sysdate, 0);
insert into notice values (ncode.nextval, 1,'공지사항 제목입니다.','공지사항 내용입니다.',sysdate,0);

delete from notice;
select * from notice;

drop sequence ncode;

CREATE SEQUENCE ncode;

insert into manager values (ncode.nextval,'홍길동','mhong','1234');
select * from manager;

insert into files values(fcode.nextval,?, to_date(?, 'YYYY-mm-dd'), ?,?,?)

create sequence fcode;

select n.title, m.name, n.writedate, n.cnt, n.content from notice n inner join manager m on n.mcode = m.mcode where ncode = ?

delete from notice where ncode = ?

select name from files where ncode = ?

update notice set title =?, content =? where ncode =?

update files set uploaddate=sysdate, name=?, beforename=?, filesize=? where fcode=?


delete from patient;

select * from patient;

select * from manager;

select * from notice;

delete from notice;

update patient set pw = '12345',nickname = '깐따삐야',gender='여', postcode = 60000, address = '서울', address2 = '강남', tel = '010-2222-2222', email = 'sample@email.com' where pcode = 8;

select count(*) from patient where id = 'id';
