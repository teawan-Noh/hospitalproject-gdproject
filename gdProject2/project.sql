insert into PATIENT values (pcode.nextval, ?, ?, ?,?,?, to_date(?,'yyyy-mm-dd'),?,?,?,?,?)

create sequence pcode;

drop sequence pcode;



delete from patient where pcode = ?


select count(*) from patient where id = ?


select id, pw from patient where id =? and pw = ?

--�����
create sequence subject_seq;
select * from subject;
insert into subject values(subject_seq.nextval, '��������', '���������� ���� �̻����� ���� �������� ���� ������ �𸣴� ����(�Ҹ�) ȯ��, ������, ���� ȯ�� ���� �����ϰ� �ֽ��ϴ�. �̻����� ���� �߻��ϴ� ��� ������ȯ�� �����ϰ� ġ���ϴ� ������Դϴ�', '031-123-4560');
insert into subject values(subject_seq.nextval, '���к��系��', '���к�-��� ���������� ��ü�� ���� ���к� ������� �к�Ǿ� ������ ȣ������ �̻��̳� ȣ���� �к� ��� �Ǵ� ǥ�� ����� ���� �������� ���� ġ���մϴ�.', '031-123-4561');
insert into subject values(subject_seq.nextval, '�˷����⳻��', '�˷����⳻�������� �ܺ� ������ ���� �鿪������ �����ļ� ���ι����� ����Ű�� ��ȯ���� �����ϰ� �����ϴ�, ������ �� �а��Դϴ�. Ư�� �˷����⼾�Ϳ� ���� �����մϴ�.', '031-123-4562');
insert into subject values(subject_seq.nextval, '�����ܰ�', '�����ܰ������� �оߺ��� ������ Ŭ����, �ΰ� �ȸ� Ŭ����, �ȸ�Ű渶�� Ŭ����, ����� Ŭ����, ���� ���� ��� Ŭ����, �������� Ŭ����, ������ Ŭ���� �� Ư��ȭ�� ���� Ŭ������ ��ϰ� �ֽ��ϴ�.', '031-123-4563');
insert into subject values(subject_seq.nextval, '�Ҿ�û�ҳ��', '�Ҿ�û�ҳ���� ��̿� û�ҳ��� �ǰ������� ���� 3�� ���������μ� �������ú��� �׸��� ��������� ��� ���߰� �ֽ��ϴ�.', '031-123-4564');
insert into subject values(subject_seq.nextval, '�Ȱ�', '�Ȱ��� ���� 110,000�� �̻��� �ܷ� ȯ�� ����� 6,000�ǿ� ���ϴ� ������ �����ϴ� ���� �ִ� �Ȱ� �������μ� �ְ��� �Ƿ����� �ֻ��� ���񽺸� ���� �ϰ� �ֽ��ϴ�.', '031-123-4565');
insert into subject values(subject_seq.nextval, '�̺����İ�', '������ ���õ� ��, ���� ���̿��̳� ���⼺ ���̿����� ��� ������ ġ�ᰡ �ʿ��� �� ������ ���̰��� �̿��� ���� ������� �ֱ� ���ð��� �̿��� ���� ������� �پ��� ���ٹ������ �����ϰ� �ֽ��ϴ�.', '031-123-4566');
insert into subject values(subject_seq.nextval, '�����ܰ�', '������ ô�߿� �ִ� ���� ���� �� ����, �δ�, �Ű�, ���� �� ���� ������ ���ؼ� �����ϰ�, ��ȯ�� �ܻ��� �����ϰ� ġ���ϴ� �о��Դϴ�.', '031-123-4567');
insert into subject values(subject_seq.nextval, '�Ǻΰ�', '�Ǻΰ��� �Ǻ� ��ȯ���� ���� �޴� ���� ȯ�ڵ��� ���� ���Ḧ �����ϰ� �ֽ��ϴ�. �� �������� ����� �Ƿ����� ÷���� �Ƿ���� ���߾����� ����� �����Ƿ����� �缺�մϴ�.', '031-123-4568');
insert into subject values(subject_seq.nextval, '��οܰ�', '��οܰ��� ũ�� ����ܰ��� ��,�ĵ��ܰ��� �������� ������, ��Ȯ�� ���� �� ġ�Ḧ �����ϸ�, �ֻ��� ���񽺸� �����ϱ� ���� ��� �Ƿ����� �ּ��� ���ϰ� �ֽ��ϴ�.', '031-123-4569');

select id, pw from doctor where id =? and pw =?
create sequence doctor_seq;
select * from doctor;
delete from doctor;

insert into doctor values(doctor_seq.nextval, 1, 'dknv1234', 'skng9710s', '��ö��', to_date('1971-6-19','yyyy-mm-dd'), 797202, 12345, '����Ư����', '���α�', '1997~2002 ���𺴿� ȫ���� ����, 2002~2007 ���𺴿� �󿬱�����, 2007~2010 ���𺴿� ��ȯ�� �������, 2010~2014 ���𺴿� �������� ����, 2015~���� ���𺴿� ���� ���ӱ���', '010-2325-5145', 'abcd@gdhp.com');
insert into doctor values(doctor_seq.nextval, 2, 'cmen0173', 'dkng0982', '�ֱټ�', to_date('1984-8-23','yyyy-mm-dd'), 298273, 08623, '��⵵', '���ֽ�', '2011~2015 ���𺴿� ���к��系�� ���ӱ��� �� �ӻ����, 2009~2015 ���𺴿� ���������а���, 2015~2016 ���Ѱ�ٰ�����ȸ ȸ��, 2016~���� ���𺴿� ���κ��ǿ������� ����', '010-9374-2074', 'qert@gdhp.com');
insert into doctor values(doctor_seq.nextval, 3, 'aknasf82', 'asong832', '������', to_date('1972-1-27','yyyy-mm-dd'), 973623, 28616, '����Ư����', '��õ��', '1997~2002 ���𺴿� �����Ǿ�ǰ�������� ������ ����, 2002~2007 ���𺴿� ÷�����п������� ����, 2007~2010 ���𺴿� ���п������¼����� ����, 2010~���� ���𺴿� �Ƿ����', '010-3972-7718', 'qtw34@gdhp.com');
insert into doctor values(doctor_seq.nextval, 4, 'sang92311', 'asmng9782', '������', to_date('1968-3-13','yyyy-mm-dd'), 493829, 39726, '����Ư����', '������', '2000~2008 ���𺴿� �����ܰ� �ӻ󰭻�, 2008~2014 ���𺴿� �����ܰ� ������, 2014~���� ���𺴿� �����ܰ� �α���', '010-1297-1723', '12rtwe@gdhp.com');
insert into doctor values(doctor_seq.nextval, 5, 'slmgn9872', 'lamgio3972', '�̰���', to_date('1971-9-9','yyyy-mm-dd'), 382034, 29712, '����Ư����', '��������', '1997~2002 ���𺴿� ���������̽� �� �Ҿƾ� ������, 2007~2009 ���𺴿� ȫ������, 2009~2014 ���𺴿� �Ҿ�û�ҳ�� ����, 2014~���� ���𺴿� Ŀ�´����̼ǽ���', '010-1974-2193', 'wtgqw@gdhp.com');
insert into doctor values(doctor_seq.nextval, 6, 'aknavsd732', 'bkne372', '������', to_date('1967-5-12','yyyy-mm-dd'), 292836, 12384, '����������', '���뱸', '1995~2007 ���𺴿� �Ȱ� �α���, 2007~2010 ���ο��ݰ��� �ڹ�����, 2010~2014 ���Ǻ����� �����������ȸ ����, 2015~���� ���𺴿� ��������', '010-1084-1649', 'sh3867@gdhp.com');
insert into doctor values(doctor_seq.nextval, 7, 'sas27847', 'aigj34972', '������', to_date('1976-12-29','yyyy-mm-dd'), 978232, 29757, '��⵵', '������', '1996~2007 ���𺴿� �̺����İ� �Ǳ���, 2009~���� ���𺴿� �̺����İ� ����, 2013~���� ���𺴿� �Կ�����', '010-5072-1975', 'bmo2791@gdhp.com');
insert into doctor values(doctor_seq.nextval, 8, 'kwoopd98', 'angi732', '����', to_date('1987-10-12','yyyy-mm-dd'), 079532, 29875, '����Ư����', '������', '2007~2010 ���𺴿� �����ܰ� ����, 2010~���� ���𺴿� �����ܰ� ������', '010-3683-0287', 'dknvi772@gdhp.com');
insert into doctor values(doctor_seq.nextval, 9, 'lsmo081243', 'ahig48271', 'ä����', to_date('1985-7-27','yyyy-mm-dd'), 093621, 38671, '����Ư����', '������', '2003~2007 ���𺴿� �Ǻΰ� ������, 2007~2010 ���𺴿� �Ǻΰ� �ӻ�������, 2010~2014 ���𺴿� �Ǻΰ� �α���, 2015~2018 ���𺴿� �Ǻΰ� ����, 2018~���� ���𺴿� �Ǻΰ� ����', '010-9716-1686', 'ci7t61@gdhp.com');
insert into doctor values(doctor_seq.nextval, 10, 's0ujg08', 'ainiey827', '������', to_date('1983-2-14','yyyy-mm-dd'), 325234, 14287, '��⵵', '�����', ' 2005~2007 ���𺴿� ��οܰ� ������, 2007~2010 ���𺴿� ȯ���߽� ���� �� ������ ����, 2010~���� ���𺴿� �ϼ�����', '010-0273-1927', 'smoie712@gdhp.com');

select id, pw from manager where id =? and pw =?

select n.ncode, n.title, m.name, n.writedate, n.cnt from notice n inner join manager m on n.mcode = m.mcode where n.title like ? or n.content like ? order by n.ncode desc

insert into notice values (ncode.nextval, ?, ?, ?, sysdate, 0);

insert into notice values(ncode.nextval,1,'�������� �����Դϴ�1','�������� �����Դϴ�1',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�2','�������� �����Դϴ�2',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�3','�������� �����Դϴ�3',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�4','�������� �����Դϴ�4',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�5','�������� �����Դϴ�5',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�6','�������� �����Դϴ�6',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�7','�������� �����Դϴ�7',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�8','�������� �����Դϴ�8',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�9','�������� �����Դϴ�9',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�10','�������� �����Դϴ�10',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�11','�������� �����Դϴ�11',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�12','�������� �����Դϴ�12',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�13','�������� �����Դϴ�13',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�14','�������� �����Դϴ�14',sysdate,0);
insert into notice values(ncode.nextval,1,'�������� �����Դϴ�15','�������� �����Դϴ�15',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�16','�������� �����Դϴ�16',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�17','�������� �����Դϴ�17',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�18','�������� �����Դϴ�18',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�19','�������� �����Դϴ�19',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�20','�������� �����Դϴ�20',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�21','�������� �����Դϴ�21',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�22','�������� �����Դϴ�22',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�23','�������� �����Դϴ�23',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�24','�������� �����Դϴ�24',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�25','�������� �����Դϴ�25',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�26','�������� �����Դϴ�26',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�27','�������� �����Դϴ�27',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�28','�������� �����Դϴ�28',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�29','�������� �����Դϴ�29',sysdate,0);
insert into notice values(ncode.nextval,2,'�������� �����Դϴ�30','�������� �����Դϴ�30',sysdate,0);


delete from notice;
drop sequence ncode;
create sequence qna_seq;
select * from notice;
select count(*) as cnt from notice

select n.title, m.name, n.writedate, n.cnt, n.content from notice n inner join manager m on n.mcode = m.mcode where ncode = 16;
select * from manager;
drop sequence ncode;

select n.ncode, n.title, m.name, to_char(n.writedate,'yyyy-mm-dd') as writedate, n.cnt from notice n inner join manager m on n.mcode = m.mcode order by n.ncode desc;

select n.title, m.name, n.writedate, n.cnt, n.content from notice n inner join manager m on n.mcode = m.mcode where ncode = 16;

select n.ncode, n.title, m.name, n.writedate, n.cnt from notice n inner join manager m on n.mcode = m.mcode where n.title like '%2%' or n.content like '%2%' order by n.ncode desc


CREATE SEQUENCE ncode;

insert into manager values (mcode.nextval,'������','manager1','1234');
insert into manager values (mcode.nextval,'������','manager2','1234');
select * from manager;
delete from manager;
delete from notice;

create sequence mcode;
delete sequence mcode;

insert into files values(fcode.nextval,?, to_date(?, 'YYYY-mm-dd'), ?,?,?)

create sequence fcode;
select * from files;

select n.title, m.name, n.writedate, n.cnt, n.content from notice n inner join manager m on n.mcode = m.mcode where ncode = 16;

delete from notice where ncode = ?

select name from files where ncode = ?

update notice set title =?, content =? where ncode =?

update files set uploaddate=sysdate, name=?, beforename=?, filesize=? where fcode=?


delete from patient;

select * from patient;

select * from manager;

select * from notice;

delete from notice;

update patient set pw = '12345',nickname = '����߾�',gender='��', postcode = 60000, address = '����', address2 = '����', tel = '010-2222-2222', email = 'sample@email.com' where pcode = 8;

select count(*) from patient where id = 'id';

ALTER TABLE approval ADD requestdate DATE;
ALTER TABLE approval DROP COLUMN requestdate;

alter table approval add restdate date;
alter table approval add day varchar(10);

drop table rest;

insert into approval values (1, 5, sysdate, '����', '����', null, 'FRI');
insert into approval values (2, 4, sysdate, '���', '�ް�', to_date('2021-03-12','yyyy-mm-dd'), null);
insert into approval values (3, 3, sysdate, '���', '�ް�', null, 'WED');
insert into approval values (4, 2, sysdate, '���', '�ް�', to_date('2021-03-15','yyyy-mm-dd'), null);
insert into approval values (5, 1, sysdate, '����', '�Һ�', null, 'MON');

alter table approval rename to rest;
alter table rest rename column acode to rcode;


select * from 
(select rownum as rn, n.ncode, n.title, m.name, to_char(n.writedate,'yyyy-mm-dd') as writedate, n.cnt 
from notice n inner join manager m on n.mcode = m.mcode order by n.ncode desc)
where rn between ? and ?;

alter table rest rename column approvedate to requestdate;

select n.ncode, n.title, m.name, to_char(n.writedate,'yyyy-mm-dd') as writedate, n.cnt
from notice n inner join manager m
on n.mcode = m.mcode order by n.ncode desc


select * from (select rownum as rn, n.ncode, n.title, m.name, to_char(n.writedate,'yyyy-mm-dd') as writedate, n.cnt
from notice n inner join manager m on n.mcode = m.mcode order by n.ncode desc) where rn between ? and ?

select * from (select rownum as rn , rsvs.* from 
(select r.rcode, r.pcode, r.rsvdate, d.scode, s.name 
from reservation r inner join doctor d on r.dcode = d.dcode inner join subject s on d.scode = s.scode 
where r.pcode = 2 order by rcode desc) rsvs) result;

select n.ncode, n.title, m.name, to_char(n.writedate,'yyyy-mm-dd') as writedate, n.cnt
from notice n inner join manager m on n.mcode = m.mcode
where n.title like '%%' or n.content like '%%' order by n.ncode desc

alter table rest modify day number

delete from rest;

select * from files order by ncode desc;
insert into files values();
insert into files values(1,94, sysdate, '�ٲ��̸�1', '�����̸�1', 3);

create sequence fileSeq;

select fileSeq.nextval from dual;

create sequence rest_seq;

select * from files;
select * from notice;
select * from manager;

delete from files;

select * from notice, files where notice.ncode = files.ncode;

select ncode, n.title, n.content, n.writedate, n.mcode, f.name, f.beforename from notice n natural join files f;

insert into files values(fileSeq.nextval,ncode.nextval,sysdate,'�̸�111','�̸�',100)

select * from (select ncode from notice order by rownum desc) where rownum = 1;

select * from files where ncode in (select ncode from notice where ncode=189);

select * from files where ncode in (select ncode from notice where ncode=?)

select n.ncode, n.title, m.name, to_char(n.writedate,'yyyy-mm-dd') as writedate, n.cnt 
from notice n inner join manager m on n.mcode = m.mcode
where n.title like '%����%' or n.content like '%����%' order by n.ncode desc

select * from (select ROW_NUMBER() OVER(ORDER BY n.writedate desc)
as rn, n.ncode, n.title, m.name, to_char(n.writedate,'yyyy-mm-dd') as writedate, n.cnt 
from notice n inner join manager m on n.mcode = m.mcode) where rn between 1 and 3

select * from (select ROW_NUMBER() OVER(ORDER BY n.writedate desc) as rn, n.ncode, n.title, m.name, to_char(n.writedate,'yyyy-mm-dd') from notice n inner join manager m on n.mcode = m.mcode  where n.title like ? or n.content like ?) where rn between ? and ?; 

select * from (select ROW_NUMBER() OVER(ORDER BY n.writedate desc)
as rn, n.ncode, n.title, m.name, to_char(n.writedate,'yyyy-mm-dd') as writedate, n.cnt
from notice n inner join manager m on n.mcode = m.mcode  where n.title like '%����%' or n.content like '%����%')
where rn between 10 and 13

select count(*) as cnt from notice where title like '%2%' or content like '%2%';

