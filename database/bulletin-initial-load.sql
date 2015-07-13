insert into sa_modiscs.geo_areas (ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
USER_INS,
USER_MOD)
select ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
USER_INS,
USER_MOD from intdms.geo_areas;
commit;

insert into sa_modiscs.geo_regions(ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
ID_AREA,
USER_INS,
USER_MOD)
select ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
ID_AREA,
USER_INS,
USER_MOD from intdms.geo_regions;
commit;

insert into sa_modiscs.geo_countries(ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
ID_ISO3166,
ID_ISO3166_3,
ID_REGION,
USER_INS,
USER_MOD)
select ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION_DE,
DESCRIPTION_EN,
DESCRIPTION_ES,
DESCRIPTION_FR,
DESCRIPTION_IT,
DESCRIPTION_JP,
DESCRIPTION_ZH,
ID,
ID_ISO3166,
ID_ISO3166_3,
ID_REGION,
USER_INS,
USER_MOD from intdms.geo_countries;
commit;

insert into sa_modiscs.dealers(ACTIVE,
ADDRESS,
CITY,
COMPLEMENT,
COUNTRY_CODE,
DATE_INS,
DATE_MOD,
DEALER_TYPE,
EMAIL,
FAX,
FLAG_AFTERMARKET,
FLAG_ALLUMINIUM,
FLAG_ASSISTANCE,
FLAG_BODYSHOP,
FLAG_DEALER,
FLAG_DEALERSELECTION,
FLAG_EUROPEASS,
FLAG_FLAGSHIP,
FLAG_HVR,
FLAG_IMPORTER,
FLAG_PDICENTER,
FLAG_POS,
FLAG_REGIONALOFFICE,
FLAG_REGIONALOFFICE_SUBSIDIARY,
FLAG_SHOWROOM,
FLAG_SUBDEALER,
FLAG_SUBSIDIARY,
GL_LATITUDE,
GL_LONGITUDE,
HOUSE_NUMBER,
ID,
NAME,
PHONE,
PROVINCE,
PROVINCE_CODE,
SW_ENABLED,
SW_HEADING,
SW_LATITUDE,
SW_LONGITUDE,
SW_PITCH,
SW_ZOOM,
USER_INS,
USER_MOD,
VILLAGE,
WEBSITE,
ZIPCODE)
select ACTIVE,
ADDRESS,
CITY,
COMPLEMENT,
COUNTRY_CODE,
DATE_INS,
DATE_MOD,
DEALER_TYPE,
EMAIL,
FAX,
FLAG_AFTERMARKET,
FLAG_ALLUMINIUM,
FLAG_ASSISTANCE,
FLAG_BODYSHOP,
FLAG_DEALER,
FLAG_DEALERSELECTION,
FLAG_EUROPEASS,
FLAG_FLAGSHIP,
FLAG_HVR,
FLAG_IMPORTER,
FLAG_PDICENTER,
FLAG_POS,
FLAG_REGIONALOFFICE,
FLAG_REGIONALOFFICE_SUBSIDIARY,
FLAG_SHOWROOM,
FLAG_SUBDEALER,
FLAG_SUBSIDIARY,
GL_LATITUDE,
GL_LONGITUDE,
HOUSE_NUMBER,
ID,
NAME,
PHONE,
PROVINCE,
PROVINCE_CODE,
SW_ENABLED,
SW_HEADING,
SW_LATITUDE,
SW_LONGITUDE,
SW_PITCH,
SW_ZOOM,
USER_INS,
USER_MOD,
VILLAGE,
WEBSITE,
ZIPCODE from intdms.dealers;
commit;

insert into sa_modiscs.vehicle_family(ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION,
ID,
USER_INS,
USER_MOD)
select ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION,
ID,
USER_INS,
USER_MOD from intdms.vehicle_family;
commit;

insert into sa_modiscs.vehicle_groups(ACTIVE,
DATE_INS,
DATE_MOD,
DCS_CATALOG_RELEASE,
DCS_CATALOG_VERSION,
DCS_MODEL,
DCS_VEHICLECLASS,
DESCRIPTION,
FAMILY_CODE,
ID,
MODEL,
PROJECT_ID,
SUSPENDED,
USER_INS,
USER_MOD)
select ACTIVE,
DATE_INS,
DATE_MOD,
DCS_CATALOG_RELEASE,
DCS_CATALOG_VERSION,
DCS_MODEL,
DCS_VEHICLECLASS,
DESCRIPTION,
FAMILY_CODE,
ID,
MODEL,
PROJECT_ID,
SUSPENDED,
USER_INS,
USER_MOD from intdms.vehicle_groups
where intdms.vehicle_groups.dcs_model in (select id from sa_modiscs.vehicle_family);
commit;

insert into sa_modiscs.vehicle_master(ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION,
FLAG_CHALLENGE,
ID,
USER_INS,
USER_MOD,
VEHICLE_GROUP_ID)
select ACTIVE,
DATE_INS,
DATE_MOD,
DESCRIPTION,
FLAG_CHALLENGE,
ID,
USER_INS,
USER_MOD,
VEHICLE_GROUP_ID from intdms.vehicle_master
where intdms.vehicle_master.VEHICLE_GROUP_ID in (select id from sa_modiscs.vehicle_groups);
commit;

Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('5','deamea15','kdoehw',null,null,'ewt',null,null,'Italiano','service@ferrari.de','353','999999','10166200','62','Attivo',null,'DCS',to_timestamp('24-GIU-15 12:16:49,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('7','itadmin5','2ZEUdE1g','Pierlorenzo','Pedrazzi','3333',null,null,'Inglese','pierlorenzo.pedrazzi@ferrari.com','3334','999999','10019100','91','Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:09,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('8','itadmin8','261276','Luciana','Cagnetta','05361953083',null,null,'Italiano','luciana.cagnetta-ext@ferrari.com','ghghg','999999','10019100','91','Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:09,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('9','jpdea009','JPDEA009',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:09,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('10','chfesa01','yTBHkonz',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:09,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('11','itczna01','ypCGxjs8',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:09,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('12','itdmsa07','SZGyf7',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:09,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('13','jpimp002','JPIMP002',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:09,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('14','tadrsf01','VSKxW4',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:09,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('15','jpdea007','JPDEA007',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:10,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('16','jpimp003','JPIMP003',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:10,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('17','tadrsg96','nTf0jM',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:10,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('18','tjpnaga01','bH8xaF',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:10,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('19','poviaa01','cv4M2vqK',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:10,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('20','defede01','NZY1dVsd',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:10,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('21','tadrsf10','rH8BAz',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:10,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('22','titscub01','eqT832',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:10,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('23','titfepv13','x7Hx3h',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:10,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
Insert into sa_modiscs.AD_USERS (ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,COST_CENTER,COMPANY,LANGUAGE,EMAIL,FAX,DEALER_CODE,FE_ROLE,FE_GROUP,STATUS,DATE_LAST_UPDATE,SOURCE,DATE_INS,USER_INS,DATE_MOD,USER_MOD,ACTIVE) values ('24','tadrsg01','Pu1tB0',null,null,null,null,null,null,null,null,null,null,null,'Attivo',null,'DCS',to_timestamp('24-GIU-15 12:21:10,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB',to_timestamp('24-GIU-15 12:56:08,000000000','DD-MON-RR HH24:MI:SSXFF'),'USR_ESB','Y');
commit;