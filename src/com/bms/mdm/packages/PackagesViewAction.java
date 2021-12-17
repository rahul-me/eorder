package com.bms.mdm.packages;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.commons.beanutils.*;

public class PackagesViewAction extends Action {
	static {
		System.out.println(" Static-Hello in ManageViewPackageAction");
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
					throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		PackagesActionForm PackageActionForm = (PackagesActionForm) form;
		PackagesDBHelper PackageDBHelper = new PackagesDBHelper();
		System.out.println("DBMS is connected");

		// int PackageId=Integer.parseInt(request.getParameter("PackageId"));

		// System.out.println("Here i get my Package Id is "+PackageId);
		// System.out.println(PackageId);

		// PackageDBHelper.deletePackageById(PackageId);

		if (request.getParameter("pkgIdforedit") != null) {

			/*
			 * PackageForm.setPackageName("varun");
			 * 
			 * System.out.println(PackageForm.getPackageName());
			 * 
			 * PropertyUtils.setProperty(PackageForm, "PackageName", "rahul"); String
			 * name =(String)PropertyUtils.getProperty(PackageForm, "PackageName");
			 * System.out.println("Here name comes "+name);
			 * 
			 * BeanUtils.copyProperties(form, PackageForm);
			 * System.out.println(PackageForm.getPackageName()); return
			 * mapping.findForward("open_createPackage");
			 */

			int pkgId = Integer.parseInt(request.getParameter("pkgIdforedit"));
			System.out.println("");
			System.out.println("Here i come when i have pckage id " + request.getParameter("PkgIdforedit"));
			System.out.println("");

			PackagesActionForm PackageDBForm;
			PackageDBForm = PackageDBHelper.getPkgById(pkgId);
			System.out.println(PackageDBForm.getPackageName());

			PackageActionForm.setPackageMasterId(pkgId);
			PackageActionForm.setPackageName(PackageDBForm.getPackageName());
			PackageActionForm.setPackageDescription(PackageDBForm.getPackageDescription());
			PackageActionForm.setPackageCharge(PackageDBForm.getPackageCharge());
			PackageActionForm.setPackageDuration(PackageDBForm.getPackageDuration());
			PackageActionForm.setPackageStatus(PackageDBForm.getPackageStatus());

			BeanUtils.copyProperties(form, PackageActionForm);
			System.out.println(PackageActionForm.getPackageName());
			System.out.println("Done with attribute setting");

			return mapping.findForward("open_pkgentry");

			/*
			 * int PackageId=Integer.parseInt(request.getParameter("PackageIdforedit"));
			 * request.setAttribute("PackageName", "super");
			 * request.setAttribute("PackageDesc", "nothing_1");
			 * request.setAttribute("PackageDuration", 12);
			 * request.setAttribute("PackageCharge", 1200);
			 * request.setAttribute("PackageId", PackageId); return
			 * mapping.findForward("open_createPackage");
			 */

		}
		if (request.getParameter("pkgIdfordelete") != null) {

			System.out.println("delete function. id is " + request.getParameter("pkgIdfordelete"));
			int pkgId = Integer.parseInt(request.getParameter("pkgIdfordelete"));
			System.out.println("pkgId");
			PackageDBHelper.deletePkgById(pkgId);

		}
		return mapping.findForward("open_pkglist");
	}

}
