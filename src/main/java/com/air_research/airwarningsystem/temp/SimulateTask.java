package com.air_research.airwarningsystem.temp;

import com.air_research.airwarningsystem.guangzhou.entity.GuangzhouAirPollutantsConcentration;
import com.air_research.airwarningsystem.guangzhou.service.impl.GuangzhouAirPollutantsConcentrationServiceImpl;
import com.air_research.airwarningsystem.harbin.entity.HarbinAirPollutantsConcentration;
import com.air_research.airwarningsystem.harbin.service.impl.HarbinAirPollutantsConcentrationServiceImpl;
import com.air_research.airwarningsystem.lanzhou.entity.LanzhouAirPollutantsConcentration;
import com.air_research.airwarningsystem.lanzhou.service.impl.LanzhouAirPollutantsConcentrationServiceImpl;
import com.air_research.airwarningsystem.lhasa.entity.LhasaAirPollutantsConcentration;
import com.air_research.airwarningsystem.lhasa.service.impl.LhasaAirPollutantsConcentrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zwell
 */
@Component
public class SimulateTask {

    @Autowired
    private GuangzhouAirPollutantsConcentrationServiceImpl gzService;

    @Autowired
    private HarbinAirPollutantsConcentrationServiceImpl hbService;

    @Autowired
    private LanzhouAirPollutantsConcentrationServiceImpl lzService;

    @Autowired
    private LhasaAirPollutantsConcentrationServiceImpl lsService;

    /**
     * 模拟数据生成，并存储值至数据库
     */
    public void simulatePredictionStore() {
        System.out.println("模拟生成数据，存储");

        LocalDate date = LocalDate.now().minusDays(5);
        int dateSpan = 100;

        gzService.saveBatch(randomCreateGZ(date, dateSpan));
        hbService.saveBatch(randomCreateHB(date, dateSpan));
        lzService.saveBatch(randomCreateLZ(date, dateSpan));
        lsService.saveBatch(randomCreateLS(date, dateSpan));

        System.out.println("模拟数据完毕");
    }

    /**
     * 模拟生成随机浓度值
     * @return
     */
    private double getRandomConcentration() {
        return (double) (new Random().nextInt(100));
    }

    /**
     * 模拟生成广州空气污染物浓度值和空气质量等级
     * @param date 起始日期
     * @param dateSpan 日期间隔
     * @return
     */
    private List<GuangzhouAirPollutantsConcentration> randomCreateGZ(LocalDate date, int dateSpan) {
        List<GuangzhouAirPollutantsConcentration> list = new ArrayList<>();

        for (int i = dateSpan; i >= 0; i--) {
            list.add(new GuangzhouAirPollutantsConcentration(date.minusDays(i), getRandomConcentration(),
                    getRandomConcentration(), getRandomConcentration(), getRandomConcentration(),
                    getRandomConcentration(), getRandomConcentration(),
                    String.valueOf(getRandomConcentration())));
        }

        return list;
    }

    /**
     * 模拟生成哈尔滨空气污染物浓度值和空气质量等级
     * @param date 起始日期
     * @param dateSpan 日期间隔
     * @return
     */
    private List<HarbinAirPollutantsConcentration> randomCreateHB(LocalDate date, int dateSpan) {
        List<HarbinAirPollutantsConcentration> list = new ArrayList<>();

        for (int i = dateSpan; i >= 0; i--) {
            list.add(new HarbinAirPollutantsConcentration(date.minusDays(i), getRandomConcentration(),
                    getRandomConcentration(), getRandomConcentration(), getRandomConcentration(),
                    getRandomConcentration(), getRandomConcentration(),
                    String.valueOf(getRandomConcentration())));
        }

        return list;
    }

    /**
     * 模拟生成兰州空气污染物浓度值和空气质量等级
     * @param date 起始日期
     * @param dateSpan 日期间隔
     * @return
     */
    private List<LanzhouAirPollutantsConcentration> randomCreateLZ(LocalDate date, int dateSpan) {
        List<LanzhouAirPollutantsConcentration> list = new ArrayList<>();

        for (int i = dateSpan; i >= 0; i--) {
            list.add(new LanzhouAirPollutantsConcentration(date.minusDays(i), getRandomConcentration(),
                    getRandomConcentration(), getRandomConcentration(), getRandomConcentration(),
                    getRandomConcentration(), getRandomConcentration(),
                    String.valueOf(getRandomConcentration())));
        }

        return list;
    }

    /**
     * 模拟生成拉萨空气污染物浓度值和空气质量等级
     * @param date 起始日期
     * @param dateSpan 日期间隔
     * @return
     */
    private List<LhasaAirPollutantsConcentration> randomCreateLS(LocalDate date, int dateSpan) {
        List<LhasaAirPollutantsConcentration> list = new ArrayList<>();

        for (int i = dateSpan; i >= 0; i--) {
            list.add(new LhasaAirPollutantsConcentration(date.minusDays(i), getRandomConcentration(),
                    getRandomConcentration(), getRandomConcentration(), getRandomConcentration(),
                    getRandomConcentration(), getRandomConcentration(),
                    String.valueOf(getRandomConcentration())));
        }

        return list;
    }
}
