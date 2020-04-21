create table comment
(
	id bigint auto_increment,
	parent_id bigint not null,
	type int not null,
	commentatar int not null,
	gmt_create bigint not null,
	gmt_modified bigint not null,
	likecount bigint default 0,
	constraint comment_pk
		primary key (id)
);