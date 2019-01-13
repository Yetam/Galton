import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Plot extends ApplicationFrame {
	final XYSeries desired;
	final XYSeries actual;

	public Plot(String title) {
		super(title);
		desired = new XYSeries("Desired function");
		actual = new XYSeries("Actual function");

		desired.add(1.0, 500.2);
		desired.add(5.0, 694.1);
		desired.add(4.0, 100.0);
		desired.add(12.5, 734.4);
		desired.add(17.3, 453.2);
		desired.add(21.2, 500.2);
		desired.add(21.9, 0);
		desired.add(25.6, 734.4);
		desired.add(30.0, 453.2);

		actual.add(1.0, 50.2);
		actual.add(5.0, 64.1);
		actual.add(4.0, 10.0);
		actual.add(1.5, 734.4);
		actual.add(17.3, 453.2);
		actual.add(1.2, 500.2);
		actual.add(21.9, 0);
		actual.add(5.6, 74.4);
		actual.add(30.0, 453.2);

		
		final XYSeriesCollection data = new XYSeriesCollection(desired);
		data.addSeries(actual);
		final JFreeChart chart = ChartFactory.createXYLineChart("pLOT", "X", "Y", data,
				PlotOrientation.VERTICAL, true, true, false);

		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);

		//
		pack();
		RefineryUtilities.centerFrameOnScreen(this);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public void setData(int[] y1, int[] y2, int[] x) {
		desired.clear();
		actual.clear();
		
		for(int i =0 ; i < y1.length; i++) {
			actual.add(x[i], y1[i]);
			desired.add(x[i], y2[i]);
		}
	}

}
