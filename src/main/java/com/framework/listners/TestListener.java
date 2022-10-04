package com.framework.listners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.commons.WebCommons;
import com.framework.reports.ReportsClass;

public class TestListener extends ReportsClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		startReporting(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.pass(result.getMethod().getMethodName()+ " is Successfully Executed");
		extent.flush();
	}

	public void onTestFailure(ITestResult result) {
		logger.fail(result.getMethod().getMethodName()+ " is Failed");
		logger.fail(result.getThrowable().getMessage());
		try {
			logger.addScreenCaptureFromPath(new WebCommons().takeScreenshotOfPage(result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		extent.flush();
	}

}
