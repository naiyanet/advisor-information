
INSERT INTO ACCOUNT(ID,NAME,EMAIL,MOBILE,ADDRESS,PASSWORD,DTYPE,ENABLE) 
        values(ACCOUNT_SEQ.nextVal,'somying','somyinggh@login','098888888','chonburi','1234','Student',1);

INSERT INTO ACCOUNT(ID,NAME,EMAIL,MOBILE,ADDRESS,PASSWORD,DTYPE,ENABLE)
        values(ACCOUNT_SEQ.nextVal,'somchai','somchaigh@login','0988889999','bangkok','1234','Student',1);

INSERT INTO ACCOUNT(ID,NAME,EMAIL,MOBILE,ADDRESS,PASSWORD,DTYPE,ENABLE) 
        values(ACCOUNT_SEQ.nextVal,'somruk','somruk@login','0988880000','bangkok','1234','Parent',1);

INSERT INTO ACCOUNT(ID,NAME,EMAIL,MOBILE,ADDRESS,PASSWORD,DTYPE,ENABLE) 
        values(ACCOUNT_SEQ.nextVal,'นายพูนศักดิ์ วงศ์สวัสดิ์','pskw@rmutk.ac.th','022879639','bangkok','1234','Teacher',1);

INSERT INTO ACCOUNT(ID,NAME,EMAIL,MOBILE,ADDRESS,PASSWORD,DTYPE,ENABLE) 
        values(ACCOUNT_SEQ.nextVal,'นายวิโรจน์ เลิศธีระชาญชัย','wirotelert@rmutk.ac.th','022879639','bangkok','1234','Teacher',1);

INSERT INTO ACCOUNT(ID,NAME,EMAIL,MOBILE,ADDRESS,PASSWORD,DTYPE,ENABLE) 
        values(ACCOUNT_SEQ.nextVal,'นายนรินทร์ จีระนันตสิน','narin.j@rmutk.ac.th','022879639','bangkok','1234','Teacher',1);

INSERT INTO ACCOUNT(ID,NAME,EMAIL,MOBILE,ADDRESS,PASSWORD,DTYPE,ENABLE) 
        values(ACCOUNT_SEQ.nextVal,'นายพนัสชัย ศรีบำรุง','panuschai@rmutk.ac.th','022879639','bangkok','1234','Teacher',1);

INSERT INTO ACCOUNT(ID,NAME,EMAIL,MOBILE,ADDRESS,PASSWORD,DTYPE,ENABLE) 
        values(ACCOUNT_SEQ.nextVal,'ว่าที่ร้อยตรี ดร. ประสิทธิ์ จิยะพานิช','prasit.ji@rmutk.ac.th','022879639','bangkok','1234','Teacher',1);

INSERT INTO ACCOUNT(ID,NAME,EMAIL,MOBILE,ADDRESS,PASSWORD,DTYPE,ENABLE) 
        values(ACCOUNT_SEQ.nextVal,'นายเฉียบวุฒิ รัตนวิไลสกุล','chaibwoot@hotmail.com','022879639','bangkok','1234','Teacher',1);

INSERT INTO ACCOUNT(ID,NAME,EMAIL,MOBILE,ADDRESS,PASSWORD,DTYPE,ENABLE,STATUS) 
        values(ACCOUNT_SEQ.nextVal,'นางสาวปรียาภรณ์ มัชฌิกะ','preeyaporn.m@rmutk.ac.th','022879639','bangkok','1234','Teacher',1,'admin');



INSERT INTO FACULTY(ID,NAME) 
        values(FACULTY_SEQ.nextVal,'computer technology');


insert into category_course (id, category_course_name ) values(CATEGORYCOURSE_SEQ.nextVal,'หมวดศึกษาทั่วไป');
insert into category_course (id, category_course_name ) values(CATEGORYCOURSE_SEQ.nextVal,'หมวดวิชาเฉพาะ');
insert into category_course (id, category_course_name ) values(CATEGORYCOURSE_SEQ.nextVal,'หมวดวิชาเลือกเสรี');

insert into CATEGORY_GROUP_COURSE (id, name , category_group_course ) values(CATEGORYGROUPCOURSE_SEQ.nextVal,'กลุ่มวิชาสังคมศาสตร์และมนุษย์ศาสตร์' , 1);
insert into CATEGORY_GROUP_COURSE (id, name , category_group_course ) values(CATEGORYGROUPCOURSE_SEQ.nextVal,'กลุ่มวิชาภาษา',1);
insert into CATEGORY_GROUP_COURSE (id, name , category_group_course ) values(CATEGORYGROUPCOURSE_SEQ.nextVal,'กลุ่มวิชาวิทยาศาสตร์และคณิตศาสตร์',1);
insert into CATEGORY_GROUP_COURSE (id, name , category_group_course ) values(CATEGORYGROUPCOURSE_SEQ.nextVal,'กลุ่มวิชาพลศึกษาหรือนันทนาการหรือกิจกรรม',1);

insert into CATEGORY_GROUP_COURSE (id, name , category_group_course ) values(CATEGORYGROUPCOURSE_SEQ.nextVal,'กลุ่มวิชาชีพพื้นฐาน',2);
insert into CATEGORY_GROUP_COURSE (id, name , category_group_course ) values(CATEGORYGROUPCOURSE_SEQ.nextVal,'กลุ่มวิชาชีพบังคับ',2);
insert into CATEGORY_GROUP_COURSE (id, name , category_group_course ) values(CATEGORYGROUPCOURSE_SEQ.nextVal,'กลุ่มวิชาชีพเลือก',2);

insert into CATEGORYADVISE(id,name_Category) values(CATEGORYADVISE_SEQ.nextVal,'หมวดวิชาการ');
insert into CATEGORYADVISE(id,name_Category) values(CATEGORYADVISE_SEQ.nextVal,'หมวดกิจกรรม');
insert into CATEGORYADVISE(id,name_Category) values(CATEGORYADVISE_SEQ.nextVal,'หมวดทั่วไป');
insert into CATEGORYADVISE(id,name_Category) values(CATEGORYADVISE_SEQ.nextVal,'อื่น ๆ ');
