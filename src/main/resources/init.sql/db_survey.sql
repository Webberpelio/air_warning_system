DROP DATABASE IF EXISTS db_air;
CREATE DATABASE db_air;

/*----------------------兰州-----------------------------*/

DROP TABLE IF EXISTS tb_lanzhou_pm25_imf;
CREATE TABLE tb_lanzhou_pm25_imf (
    id int not null,
    pred_date date not null,
    imf1 double,
    imf2 double,
    imf3 double,
    imf4 double,
    imf5 double,
    imf6 double,
    primary key (id)
);

DROP TABLE IF EXISTS tb_lanzhou_pm10_imf;
CREATE TABLE tb_lanzhou_pm10_imf (
                             pred_date date not null,
                             imf1 double,
                             imf2 double,
                             imf3 double,
                             imf4 double,
                             imf5 double,
                             imf6 double,
                             imf7 double,
                             primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lanzhou_so2_imf;
CREATE TABLE tb_lanzhou_so2_imf (
                             pred_date date not null,
                             imf1 double,
                             imf2 double,
                             imf3 double,
                             imf4 double,
                             imf5 double,
                             primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lanzhou_co_imf;
CREATE TABLE tb_lanzhou_co_imf (
                             pred_date date not null,
                             imf1 double,
                             imf2 double,
                             imf3 double,
                             imf4 double,
                             imf5 double,
                             imf6 double,
                             primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lanzhou_no2_imf;
CREATE TABLE tb_lanzhou_no2_imf (
                             pred_date date not null,
                             imf1 double,
                             imf2 double,
                             imf3 double,
                             imf4 double,
                             imf5 double,
                             imf6 double,
                             primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lanzhou_o3_imf;
CREATE TABLE tb_lanzhou_o3_imf (
                             pred_date date not null,
                             imf1 double,
                             imf2 double,
                             imf3 double,
                             imf4 double,
                             imf5 double,
                             primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lanzhou_air_pollutants_concentration;
CREATE TABLE tb_lanzhou_air_pollutants_concentration (
                                                         pred_date date not null,
                                                         pm25 double,
                                                         pm10 double,
                                                         so2 double,
                                                         co double,
                                                         no2 double,
                                                         o3 double,
                                                         aq_level varchar(10),
                                                         primary key (pred_date)
);

/*----------------------广州-----------------------------*/

DROP TABLE IF EXISTS tb_guangzhou_pm25_imf;
CREATE TABLE tb_guangzhou_pm25_imf (
    pred_date date not null,
    imf1 double,
    imf2 double,
    imf3 double,
    imf4 double,
    imf5 double,
    primary key (pred_date)
);

DROP TABLE IF EXISTS tb_guangzhou_pm10_imf;
CREATE TABLE tb_guangzhou_pm10_imf (
                                       pred_date date not null,
                                       imf1 double,
                                       imf2 double,
                                       imf3 double,
                                       imf4 double,
                                       imf5 double,
                                       imf6 double,
                                       primary key (pred_date)
);

DROP TABLE IF EXISTS tb_guangzhou_so2_imf;
CREATE TABLE tb_guangzhou_so2_imf (
                                       pred_date date not null,
                                       imf1 double,
                                       imf2 double,
                                       imf3 double,
                                       imf4 double,
                                       imf5 double,
                                       imf6 double,
                                       primary key (pred_date)
);

DROP TABLE IF EXISTS tb_guangzhou_co_imf;
CREATE TABLE tb_guangzhou_co_imf (
                                       pred_date date not null,
                                       imf1 double,
                                       imf2 double,
                                       imf3 double,
                                       imf4 double,
                                       imf5 double,
                                       imf6 double,
                                       primary key (pred_date)
);

DROP TABLE IF EXISTS tb_guangzhou_no2_imf;
CREATE TABLE tb_guangzhou_no2_imf (
                                     pred_date date not null,
                                     imf1 double,
                                     imf2 double,
                                     imf3 double,
                                     imf4 double,
                                     primary key (pred_date)
);

DROP TABLE IF EXISTS tb_guangzhou_o3_imf;
CREATE TABLE tb_guangzhou_o3_imf (
                           pred_date date not null,
                           imf1 double,
                           imf2 double,
                           imf3 double,
                           imf4 double,
                           imf5 double,
                           primary key (pred_date)
);

DROP TABLE IF EXISTS tb_guangzhou_air_pollutants_concentration;
CREATE TABLE tb_guangzhou_air_pollutants_concentration (
                                                 pred_date date not null,
                                                 pm25 double,
                                                 pm10 double,
                                                 so2 double,
                                                 co double,
                                                 no2 double,
                                                 o3 double,
                                                 aq_level varchar(10),
                                                 primary key (pred_date)
);

/*----------------------哈尔滨-----------------------------*/

DROP TABLE IF EXISTS tb_harbin_pm25_imf;
CREATE TABLE tb_harbin_pm25_imf (
                                       pred_date date not null,
                                       imf1 double,
                                       imf2 double,
                                       imf3 double,
                                       imf4 double,
                                       imf5 double,
                                       primary key (pred_date)
);

DROP TABLE IF EXISTS tb_harbin_pm10_imf;
CREATE TABLE tb_harbin_pm10_imf (
                                       pred_date date not null,
                                       imf1 double,
                                       imf2 double,
                                       imf3 double,
                                       imf4 double,
                                       imf5 double,
                                       primary key (pred_date)
);

DROP TABLE IF EXISTS tb_harbin_so2_imf;
CREATE TABLE tb_harbin_so2_imf (
                                      pred_date date not null,
                                      imf1 double,
                                      imf2 double,
                                      imf3 double,
                                      imf4 double,
                                      imf5 double,
                                      primary key (pred_date)
);

DROP TABLE IF EXISTS tb_harbin_co_imf;
CREATE TABLE tb_harbin_co_imf (
                                     pred_date date not null,
                                     imf1 double,
                                     imf2 double,
                                     imf3 double,
                                     imf4 double,
                                     imf5 double,
                                     primary key (pred_date)
);

DROP TABLE IF EXISTS tb_harbin_no2_imf;
CREATE TABLE tb_harbin_no2_imf (
                                      pred_date date not null,
                                      imf1 double,
                                      imf2 double,
                                      imf3 double,
                                      imf4 double,
                                      imf5 double,
                                      imf6 double,
                                      primary key (pred_date)
);

DROP TABLE IF EXISTS tb_harbin_o3_imf;
CREATE TABLE tb_harbin_o3_imf (
                                     pred_date date not null,
                                     imf1 double,
                                     imf2 double,
                                     imf3 double,
                                     imf4 double,
                                     imf5 double,
                                     primary key (pred_date)
);

DROP TABLE IF EXISTS tb_harbin_air_pollutants_concentration;
CREATE TABLE tb_harbin_air_pollutants_concentration (
                                                           pred_date date not null,
                                                           pm25 double,
                                                           pm10 double,
                                                           so2 double,
                                                           co double,
                                                           no2 double,
                                                           o3 double,
                                                           aq_level varchar(10),
                                                           primary key (pred_date)
);

/*----------------------拉萨----------------------------*/

DROP TABLE IF EXISTS tb_lhasa_pm25_imf;
CREATE TABLE tb_lhasa_pm25_imf (
                                    pred_date date not null,
                                    imf1 double,
                                    imf2 double,
                                    imf3 double,
                                    imf4 double,
                                    imf5 double,
                                    primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lhasa_pm10_imf;
CREATE TABLE tb_lhasa_pm10_imf (
                                    pred_date date not null,
                                    imf1 double,
                                    imf2 double,
                                    imf3 double,
                                    imf4 double,
                                    imf5 double,
                                    primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lhasa_so2_imf;
CREATE TABLE tb_lhasa_so2_imf (
                                   pred_date date not null,
                                   imf1 double,
                                   imf2 double,
                                   imf3 double,
                                   imf4 double,
                                   imf5 double,
                                   primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lhasa_co_imf;
CREATE TABLE tb_lhasa_co_imf (
                                  pred_date date not null,
                                  imf1 double,
                                  imf2 double,
                                  imf3 double,
                                  imf4 double,
                                  imf5 double,
                                  primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lhasa_no2_imf;
CREATE TABLE tb_lhasa_no2_imf (
                                   pred_date date not null,
                                   imf1 double,
                                   imf2 double,
                                   imf3 double,
                                   imf4 double,
                                   imf5 double,
                                   imf6 double,
                                   primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lhasa_o3_imf;
CREATE TABLE tb_lhasa_o3_imf (
                                  pred_date date not null,
                                  imf1 double,
                                  imf2 double,
                                  imf3 double,
                                  imf4 double,
                                  imf5 double,
                                  primary key (pred_date)
);

DROP TABLE IF EXISTS tb_lhasa_air_pollutants_concentration;
CREATE TABLE tb_lhasa_air_pollutants_concentration (
                                                        pred_date date not null,
                                                        pm25 double,
                                                        pm10 double,
                                                        so2 double,
                                                        co double,
                                                        no2 double,
                                                        o3 double,
                                                        aq_level varchar(10),
                                                        primary key (pred_date)
);