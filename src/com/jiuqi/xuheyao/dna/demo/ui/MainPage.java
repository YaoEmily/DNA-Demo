package com.jiuqi.xuheyao.dna.demo.ui;

import com.jiuqi.dna.bap.common.constants.BapImages;
import com.jiuqi.dna.ui.common.constants.JWT;
import com.jiuqi.dna.ui.components.SearchBar;
import com.jiuqi.dna.ui.custom.pageBar.Pager;
import com.jiuqi.dna.ui.custom.pageBar.Pager.PagerType;
import com.jiuqi.dna.ui.template.launch.TemplateLauncher;
import com.jiuqi.dna.ui.template.launch.TemplateWindow;
import com.jiuqi.dna.ui.wt.events.ActionEvent;
import com.jiuqi.dna.ui.wt.events.ActionListener;
import com.jiuqi.dna.ui.wt.graphics.ImageDescriptor;
import com.jiuqi.dna.ui.wt.grid2.Grid2;
import com.jiuqi.dna.ui.wt.layouts.FillLayout;
import com.jiuqi.dna.ui.wt.layouts.GridData;
import com.jiuqi.dna.ui.wt.layouts.GridLayout;
import com.jiuqi.dna.ui.wt.widgets.Composite;
import com.jiuqi.dna.ui.wt.widgets.Label;
import com.jiuqi.dna.ui.wt.widgets.Page;
import com.jiuqi.dna.ui.wt.widgets.SashForm;
import com.jiuqi.dna.ui.wt.widgets.ScrolledPanel;
import com.jiuqi.dna.ui.wt.widgets.ToolBar;
import com.jiuqi.dna.ui.wt.widgets.ToolItem;
import com.jiuqi.dna.ui.wt.widgets.Tree;
import com.jiuqi.dna.ui.wt.widgets.TreeItem;

public class MainPage extends Page {

	private Tree tree;
	private ImageDescriptor createImage;
	
	public MainPage(Composite parent) {
		super(parent);
		this.setLayout(new GridLayout());
		
		//在页面中，创建工具栏
		ToolBar toolBar = new ToolBar(this,JWT.RIGHT);
		toolBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		ToolItem createItem = new ToolItem(toolBar);
		createItem.setText("新增");
		createImage = getContext().find(ImageDescriptor.class, BapImages.ico_create);
		createItem.setImage(createImage);
		
//		Menu menu = new Menu(toolBar);
//		MenuItem editDept = new MenuItem(menu, JWT.PUSH);
//		editDept.setText("新增部门");
//		MenuItem editPerson = new MenuItem(menu, JWT.PUSH);
//		editPerson.setText("新增人员");
//		createItem.setMenu(menu);
		
		ToolItem createDeptItem = new ToolItem(toolBar);
		createDeptItem.setText("新增部门");
		//添加点击事件
		createDeptItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TemplateWindow tw = TemplateLauncher.openTemplateWindow(MainPage.this, "editDeptPage", JWT.CLOSE|JWT.MODAL|JWT.CANCEL, JWT.CANCEL|JWT.OK, MainPage.this);
				tw.setTitle("新增部门信息");
				tw.setSize(400, 300);
				tw.setIcon(createImage);
			}
		});
		
		editPerson.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TemplateWindow tw = TemplateLauncher.openTemplateWindow(MainPage.this, "editPersonPage", JWT.CLOSE|JWT.MODAL|JWT.CANCEL|JWT.MAXIMUM, JWT.NONE);
				tw.setTitle("新增人员信息");
				tw.setSize(500, 300);
				tw.setIcon(createImage);
			}
			
		});
		
		ToolItem createPersonItem = new ToolItem(toolBar);
		createPersonItem.setText("新增人员");
		
		ToolItem updateItem = new ToolItem(toolBar);
		updateItem.setText("修改");
		ImageDescriptor updateImage = getContext().find(ImageDescriptor.class, BapImages.ico_modify_img);
		updateItem.setImage(updateImage);
		
		ToolItem deleteItem = new ToolItem(toolBar);
		deleteItem.setText("删除");
		ImageDescriptor deleteImage = getContext().find(ImageDescriptor.class, BapImages.ico_delete);
		deleteItem.setImage(deleteImage);
		
		ToolItem upItem = new ToolItem(toolBar);
		upItem.setText("上移");
		ImageDescriptor upImage = getContext().find(ImageDescriptor.class, BapImages.ico_moveup);
		upItem.setImage(upImage);
		
		ToolItem downItem = new ToolItem(toolBar);
		downItem.setText("下移");
		ImageDescriptor downImage = getContext().find(ImageDescriptor.class, BapImages.ico_movedown);
		downItem.setImage(downImage);
		
		ToolItem closeItem = new ToolItem(toolBar);
		closeItem.setText("关闭");
		ImageDescriptor closeImage = getContext().find(ImageDescriptor.class, BapImages.ico_close_window);
		closeItem.setImage(closeImage);
		
		SashForm sashForm = new SashForm(this);
		sashForm.setLayoutData(new GridData(GridData.FILL_BOTH));
		sashForm.setWeights("1:3");
		
		//在sashform左边容器中放入树形控件
		Composite firstComposite = sashForm.getFirstComposite();
		//全布局模式
		firstComposite.setLayout(new FillLayout());
		
		tree = new Tree(firstComposite);
		TreeItem itemRoot = new TreeItem(tree);
		itemRoot.setText("久其软件");
		
		TreeItem itemBeijing = new TreeItem(itemRoot);
		itemBeijing.setText("北京久其");
		TreeItem itemShanghai = new TreeItem(itemRoot);
		itemShanghai.setText("上海久其");
		TreeItem itemGuangzhou = new TreeItem(itemRoot);
		itemGuangzhou.setText("广州久其");
		TreeItem itemHefei = new TreeItem(itemRoot);
		itemHefei.setText("合肥久其");
		TreeItem itemZhengzhou = new TreeItem(itemRoot);
		itemZhengzhou.setText("郑州久其");
		TreeItem itemShijiazhuang = new TreeItem(itemRoot);
		itemShijiazhuang.setText("石家庄久其");
		TreeItem itemShenyang = new TreeItem(itemRoot);
		itemShenyang.setText("沈阳久其");
		TreeItem itemNingxia = new TreeItem(itemRoot);
		itemNingxia.setText("宁夏久其");
		
		Composite secondComposite = sashForm.getSecondComposite();
		secondComposite.setLayout(new GridLayout());
		//查询控件容器
		//Composite comSearch = new Composite(secondComposite);
		ScrolledPanel scrolledPanel = new ScrolledPanel(secondComposite);
		Composite comSearch = scrolledPanel.getComposite();
		comSearch.setLayout(new GridLayout(2));
		new Label(comSearch).setText("员工姓名");
		new SearchBar(comSearch, "请输入关键字"){

			@Override
			protected void searchTextChanged(String arg0) {
				// TODO searchbar的处理逻辑
				
			}
			
		};
		
		//网格控件容器
		Composite comGrid = new Composite(secondComposite);
		comGrid.setLayoutData(new GridData(GridData.FILL_BOTH));
		comGrid.setLayout(new FillLayout());
		Grid2 grid2 = new Grid2(comGrid);
		
		//分页控件容器
		Composite comPage = new Composite(secondComposite);
		comPage.setLayout(new FillLayout());
		new Pager(comPage, PagerType.DEFAULT);
		
	}
	
	public void AddTreeItem(DeptInfo deptInfo)
	{
		TreeItem item = new TreeItem(tree);
		item.setText(deptInfo.deptName);
	}
}
