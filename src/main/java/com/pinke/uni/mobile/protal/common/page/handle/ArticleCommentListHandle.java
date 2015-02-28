package com.pinke.uni.mobile.protal.common.page.handle;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.ls.ITArticleinfoLS;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 14-12-10.
 */
public class ArticleCommentListHandle extends BaseServiceHandle {

    private Log log = SSBBus.getLog(this.getClass());
    private static ITArticleinfoLS articleinfoLS = (ITArticleinfoLS) SSBBus.findDomainService("tarticleinfoLS");
    private static IBBSFS bbsfs = (IBBSFS) SSBBus.findDomainService("mBBSFS");

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String articleindexStr = request.getParameter("aid");
        String rowStr = request.getParameter("r");
        if (StringUtils.isEmpty(articleindexStr) || !NumberUtils.isNumber(articleindexStr)) {
            return null;
        }
        Long articleindex = Long.valueOf(articleindexStr);
        Integer row = NumberUtils.isNumber(rowStr) ? Integer.valueOf(rowStr) : 0;
        try {
//            TArticleinfo tArticleinfo = new TArticleinfo();
//            tArticleinfo.setArticleindex(articleindex);
//            tArticleinfo = articleinfoLS.getTArticleinfo(tArticleinfo);
//            request.setAttribute("articleinfo", tArticleinfo);
//            TArticleinfoComment tArticleinfoComment = new TArticleinfoComment();
            TableDataInfo commentPageinfo = (TableDataInfo) bbsfs.getArticleCommentList(articleindex, row/10 + 1, 10);
            request.setAttribute("page", commentPageinfo);
            return this;
        } catch (Exception e) {
            log.error("articleindex is " + articleindexStr + " ,but page error!");
        }
        return null;
    }
}
