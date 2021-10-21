insert into PATIENT values (pcode.nextval, ?, ?, ?,?,?, to_date(?,'yyyy-mm-dd'),?,?,?,?,?)

create sequence pcode;

update patient set pw = ?, postcode = ?, address = ?, address2 = ?, tel = ?, email = ? where pcode = ?

delete from patient where pcode = ?


select count(*) from patient where id = ?


select id, pw from patient where id =? and pw = ?

select id, pw from doctor where id =? and pw =?

select id, pw from manager where id =? and pw =?

select n.ncode, n.title, m.name, n.writedate, n.cnt from notice n inner join manager m on n.mcode = m.mcode where n.title like ? or n.content like ? order by n.ncode desc

insert into notice values (ncode.nextval, ?, ?, ?, to_date(?,'yyyy-mm-dd'), 0);

CREATE SEQUENCE ncode;

insert into files values(fcode.nextval,?, to_date(?, 'yyyy-mm-dd'), ?,?,?)

create sequence fcode;

select n.title, m.name, n.writedate, n.cnt, n.content from notice n inner join manager m on n.mcode = m.mcode where ncode = ?

delete from notice where ncode = ?

select name from files where ncode = ?

update notice set title =?, content =? where ncode =?

update files set uploaddate=sysdate, name=?, beforename=?, filesize=? where fcode=?





