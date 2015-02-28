package com.pinke.uni.lottery;

import com.pinke.uni.lottery.common.GameConstants;
import com.pinke.uni.lottery.model.BallTicket;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 15-1-9.
 */
public class BallUtil {

    private BallUtil() {
    }


    public static Integer getSumCount(List<BallTicket> ballTickets) {
        Integer count = 0;
        for (BallTicket obj : ballTickets) {
            count += obj.getCount() * obj.getMultiple();
        }
        return count;
    }

    public static Long getMoneySum(List<BallTicket> balllist) {
        return 200l * getSumCount(balllist);
    }

    public static List<BallTicket> getBallListFromBallString(String balllist, String delim, String lottery) {
        List<BallTicket> ballTickets = new ArrayList<BallTicket>();
        if (GameConstants.LOTTERY_TYPE.SSQ.equals(lottery)) {
            String[] arr = balllist.split(delim);
            for (String ball : arr) {
                BallTicket ballTicket = new BallTicket(ball, 1, lottery);
                ballTickets.add(ballTicket);
            }
        }
        return ballTickets;
    }

    public static String formatSingleIssueBallListToPrintBallString(List<BallTicket> ballTickets, final String issuetype) {
        List<BallTicket> temp = getBallTicketListWithGameType(ballTickets, issuetype);
        return formatBallListToPrintBallString(temp);
    }

    public static String formatBallListToPrintBallString(List<BallTicket> ballTickets) {
        StringBuffer sb = new StringBuffer();
        for (BallTicket obj : ballTickets) {
            sb.append(obj.getCode() + "#");
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public static List<BallTicket> getBallTicketListWithGameType(List<BallTicket> ballTickets, final String issuetype) {
        List<BallTicket> temp = new ArrayList<BallTicket>();
        temp = (List<BallTicket>) CollectionUtils.union(temp, ballTickets);
        CollectionUtils.filter(temp, new Predicate() {
                    @Override
                    public boolean evaluate(Object object) {
                        BallTicket obj = (BallTicket) object;
                        return obj.getType().equals(issuetype);
                    }
                }
        );
        return temp;
    }

}
