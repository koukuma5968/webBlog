package com.model.sql.dao;

import com.param.HistoryBean;

public class HistoryDao extends DaoBase {

	public static int updateDownloadSeqReset() {
		return articleMapper.UPD_CONTENT_DL_SEQ_RESET();
	}

	public static int updateDownloadSeqIncriment() {
		return articleMapper.UPD_CONTENT_DL_SEQ_INCRIMENT();
	}

	public static int insertDownloadHistory(HistoryBean bean) {
		return articleMapper.INS_DL_HISTORY(bean);
	}
}
