package com.xinchen.ssm.quartz.controller;

import com.xinchen.ssm.quartz.service.JobService;
import com.xinchen.ssm.quartz.service.PageTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ChenXin on 2016/10/26.
 */
@Controller
@RequestMapping("quartz")
public class SchedulerController {

    private boolean init = false;

    @Autowired
    private JobService jobService;
    @RequestMapping("/show")
    public String show(HttpServletRequest request){
        if (!init) {
            jobService.stopScheduler();
        }

        getTriggers(request);
        return "quartz/show";
    }

    @RequestMapping("/{name}/{group}/stop")
    public String stop(@PathVariable String name, @PathVariable String group){
        jobService.stopJob(name, group);
        return "redirect:quartz/show";
    }

    @RequestMapping("/{name}/{group}/del")
    public String del(@PathVariable String name, @PathVariable String group){
        jobService.delJob(name, group);
        return "redirect:quartz/show";
    }

    @RequestMapping("/{name}/{group}/{cron}/modify")
    public String modify(@PathVariable String name, @PathVariable String group ,@PathVariable String cron){
        jobService.modifyTrigger(name, group, cron);
        return "redirect:quartz/show";
    }

    @RequestMapping("/{name}/{group}/startNow")
    public String stratNow(@PathVariable String name, @PathVariable String group){
        jobService.startNowJob(name, group);
        return "redirect:quartz/show";
    }

    @RequestMapping("/{name}/{group}/resume")
    public String resume(@PathVariable String name, @PathVariable String group){
        jobService.restartJob(name, group);
        return "redirect:quartz/show";
    }

    public void getTriggers(HttpServletRequest request){
        List<PageTrigger> triggers = jobService.getTriggersInfo();
        System.out.println(triggers.size());
        request.setAttribute("triggers", triggers);
    }


}
