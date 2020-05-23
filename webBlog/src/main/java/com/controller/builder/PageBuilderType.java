package com.controller.builder;

import java.util.ArrayList;
import java.util.HashMap;

import com.model.html.body.side.SideBean;
import com.model.html.body.top.TopBean;
import com.model.html.footer.FooterBean;
import com.model.html.header.HeaderBean;

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

			String articlePath = "/SpringToolInst";
			String articleName = "/SpringToolInst";
			String articleCss = "/article/SpringToolInst/stylesheet.css";

			HashMap<String, String> articleBean = new HashMap<String, String>();
			articleBean.put("articlePath", articlePath);
			articleBean.put("articleName", articleName);
			articleBean.put("articleCss", articleCss);

			return articleBean;
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
