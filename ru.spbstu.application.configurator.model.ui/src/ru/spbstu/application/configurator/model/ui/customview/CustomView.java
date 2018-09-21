package ru.spbstu.application.configurator.model.ui.customview;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;



public class CustomView extends ViewPart {

    public static final String ID = "ru.spbstu.application.configurator.model.ui.customview";

    private TableViewer viewer;
    // static fields to hold the images
  

    public void createPartControl(Composite parent) {
    	 GridLayout layout = new GridLayout(2,false);
    	 parent.setLayout(layout);
         Label label = new Label(parent, SWT.NONE);
         label.setText("0 items");
         createViewer(parent);
    }

    private void createViewer(Composite parent) {
        viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        createColumns(parent, viewer);
        final Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        viewer.setContentProvider(new ArrayContentProvider());
        //viewer.setInput(parent);
        getSite().setSelectionProvider(viewer);
        GridData gridData = new GridData();
        gridData.verticalAlignment = GridData.FILL;
        gridData.horizontalSpan = 2;
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = true;
        gridData.horizontalAlignment = GridData.FILL;
        viewer.getControl().setLayoutData(gridData);
    }

    public TableViewer getViewer() {
        return viewer;
    }

    private void createColumns(final Composite parent, final TableViewer viewer) {
        String[] titles = { "Description", "Resource", "Pathr", "Location", "Type" };
        int[] bounds = { 300, 100, 100, 100,100 };

        TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
        col = createTableViewerColumn(titles[1], bounds[1], 1);
        col = createTableViewerColumn(titles[2], bounds[2], 2);
        col = createTableViewerColumn(titles[3], bounds[3], 3);
        col = createTableViewerColumn(titles[4], bounds[4], 4);

    }

    private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
        final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
        final TableColumn column = viewerColumn.getColumn();
        column.setText(title);
        column.setWidth(bound);
        column.setResizable(true);
        column.setMoveable(true);
        return viewerColumn;
    }

    public void setFocus() {
        viewer.getControl().setFocus();
    }
}