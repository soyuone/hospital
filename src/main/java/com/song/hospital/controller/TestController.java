package com.song.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.hospital.common.controller.ControllerBase;
import com.song.hospital.common.util.IConstant;
import com.song.hospital.common.util.ResultInfo;
import com.song.hospital.service.PrintTask;

@Controller
@RequestMapping("api/test")
public class TestController extends ControllerBase {

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResultInfo TestThread() {
		
		ResultInfo resultInfo = new ResultInfo();

        taskExecutor.execute(new PrintTask("Thread 1"));  
        taskExecutor.execute(new PrintTask("Thread 2"));  
        taskExecutor.execute(new PrintTask("Thread 3"));  
        taskExecutor.execute(new PrintTask("Thread 4"));  
        taskExecutor.execute(new PrintTask("Thread 5"));  
        // 检查活动的线程，如果活动线程数为0则关闭线程池  
        for(;;){  
                int count = taskExecutor.getActiveCount();  
                System.out.println("Active Threads : " + count);  
                try{  
                        Thread.sleep(1000);  
                }catch(InterruptedException e){  
                        e.printStackTrace();  
                }  
                if(count==0){  
                        taskExecutor.shutdown();  
                        break;  
                }  
        }  
		
		resultInfo.setCode(IConstant.SUCCESS);
		resultInfo.setMsg("成功");
		
		return resultInfo;
	}

}
