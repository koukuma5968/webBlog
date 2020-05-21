package com.controller.builder;

import java.util.ArrayList;

import com.model.html.body.side.SideBean;
import com.model.html.body.top.TopBean;
import com.model.html.footer.FooterBean;
import com.model.html.header.HeaderBean;
import com.model.sql.dto.body.article.LargeDto;

public enum PageBuilderType implements BuilderInterface {

	HEAD {
		@Override
		public Object createBody() {

			HeaderBean head = new HeaderBean();
			head.setTitle("ブログ（仮）");
			return head;
		}
	},
	TOP {

		@Override
		public Object createBody() {

			String[] strs = {"ホーム", "java"};
			ArrayList<TopBean> topLinkList = new ArrayList<TopBean>();
			TopBean top = null;
			for (String str : strs) {
				top = new TopBean();
				top.setLink(str);
				topLinkList.add(top);
			}

			return topLinkList;
		}
		
	},
	ARTICLE {
		@Override
		public Object createBody() {

			LargeDto large = new LargeDto();

			large.setHeadLine("Spring WEBアプリケーション");
			large.setHeadText("Spring bootを使ったWEBアプリケーションの作成<BR>導入からプロジェクト作成まで");

			return large;
		}
	},
	SIDE {
		@Override
		public Object createBody() {

			String[][] sidestrs = {{"Title", "Spring WEBアプリケーション"}};

			ArrayList<SideBean> sideLinkList = new ArrayList<SideBean>();
			SideBean side = null;
			for (String[] sidestr : sidestrs) {

				side = new SideBean();

				side.setLinkId(sidestr[0]);
				side.setLinkText(sidestr[1]);
				sideLinkList.add(side);
			}

			return sideLinkList;
		}
	},
	FOOT {
		@Override
		public Object createBody() {

			FooterBean foot = new FooterBean();

			return foot;
		}
	};
}
