package sur.softsurena.graficas;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import static sur.softsurena.metodos.M_Dato_Nacimiento.getPesoKG;
import static sur.softsurena.metodos.M_Paciente.getSexoPaciente;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class PesoParaEdadChicoChica {

    private final String sexo;
    private Float SD3Neg;
    private Float SD2Neg;
    private Float SD1Neg;
    private Float SD0;
    private Float SD1;
    private Float SD2;
    private Float SD3;
    private final int tamanoFigura;
    private final int idPaciente;

    public PesoParaEdadChicoChica(int idPaciente, int tamanoFigura) {
        sexo = getSexoPaciente(idPaciente);
        this.tamanoFigura = tamanoFigura;
        this.idPaciente = idPaciente;
    }

    private XYSeriesCollection createDataset() {
        XYSeriesCollection localXYSeriesCollection = new XYSeriesCollection();
        try {
            BufferedReader localBufferedReader = new BufferedReader(
                    new InputStreamReader(XYSeriesCollection.class.
                            getClassLoader().getResourceAsStream(
                                    "datos/PesoParaEdad.txt")));
            XYSeries localXYSeries1 = new XYSeries("SD3neg", true, true);
            XYSeries localXYSeries2 = new XYSeries("SD2neg", true, true);
            XYSeries localXYSeries3 = new XYSeries("SD1neg", true, true);
            XYSeries localXYSeries4 = new XYSeries("SD0", true, true);
            XYSeries localXYSeries5 = new XYSeries("SD1", true, true);
            XYSeries localXYSeries6 = new XYSeries("SD2", true, true);
            XYSeries localXYSeries7 = new XYSeries("SD3", true, true);
            XYSeries localXYSeries8 = new XYSeries("DATO", true, true);

            String str;
            
            for (str = localBufferedReader.readLine();
                    str != null; str = localBufferedReader.readLine()) {
                int f1 = Integer.parseInt(str.substring(0, 4).trim());//Para el Mes
                if (Integer.parseInt(str.substring(10, 13).trim()) == (sexo.equals("m") ? 1 : 2)) {//Determina Sexo
                    localXYSeries1.add(f1, Float.parseFloat(str.substring(59, 65).trim()));//SD3Neg
                    localXYSeries2.add(f1, Float.parseFloat(str.substring(69, 75).trim()));//SD2Neg
                    localXYSeries3.add(f1, Float.parseFloat(str.substring(79, 85).trim()));//SD1Neg
                    localXYSeries4.add(f1, Float.parseFloat(str.substring(89, 95).trim()));//SD0
                    localXYSeries5.add(f1, Float.parseFloat(str.substring(99, 105).trim()));//SD1
                    localXYSeries6.add(f1, Float.parseFloat(str.substring(109, 115).trim()));//SD2
                    localXYSeries7.add(f1, Float.parseFloat(str.substring(119, 123).trim()));//SD3
                    if (f1 == 60) {
                        SD3Neg = Float.valueOf(str.substring(59, 65).trim());
                        SD2Neg = Float.valueOf(str.substring(69, 75).trim());
                        SD1Neg = Float.valueOf(str.substring(79, 85).trim());
                        SD0 = Float.valueOf(str.substring(89, 95).trim());
                        SD1 = Float.valueOf(str.substring(99, 105).trim());
                        SD2 = Float.valueOf(str.substring(109, 115).trim());
                        SD3 = Float.valueOf(str.substring(119, 123).trim());
                    }
                }

            }

            ResultSet rs = getPesoKG(idPaciente);
            try {
                while (rs.next()) {
                    localXYSeries8.add(rs.getFloat(3), rs.getFloat(4));
                }
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }

            localXYSeriesCollection.addSeries(localXYSeries1);
            localXYSeriesCollection.addSeries(localXYSeries2);
            localXYSeriesCollection.addSeries(localXYSeries3);
            localXYSeriesCollection.addSeries(localXYSeries4);
            localXYSeriesCollection.addSeries(localXYSeries5);
            localXYSeriesCollection.addSeries(localXYSeries6);
            localXYSeriesCollection.addSeries(localXYSeries7);
            localXYSeriesCollection.addSeries(localXYSeries8);

        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return localXYSeriesCollection;
    }

    private JFreeChart createChart(XYDataset paramXYDataset) {

        JFreeChart localJFreeChart
                = ChartFactory.createXYLineChart(null,
                        "Mes", "Medida Kg",
                        paramXYDataset, PlotOrientation.VERTICAL, true, true, false);

        TextTitle localTextTitle1 = new TextTitle("Peso para la edad",
                new Font("SansSerif", 1, 14));

        TextTitle localTextTitle2 = new TextTitle(
                "Nacimiento a 5 años, Puntuación \"Z\"",
                new Font("SansSerif", 0, 11));

        localJFreeChart.setTitle(localTextTitle1);
        localJFreeChart.addSubtitle(localTextTitle2);

        XYPlot localXYPlot = (XYPlot) localJFreeChart.getPlot();

        localXYPlot.setDomainCrosshairVisible(true);
        localXYPlot.setDomainCrosshairLockedOnData(true);
        localXYPlot.setRangeCrosshairVisible(true);
        localXYPlot.setRangeCrosshairLockedOnData(true);
        localXYPlot.setDomainZeroBaselineVisible(true);
        localXYPlot.setRangeZeroBaselineVisible(true);

        localXYPlot.setDomainPannable(true);
        localXYPlot.setRangePannable(true);

        NumberAxis localNumberAxis1 = (NumberAxis) localXYPlot.getDomainAxis();

        localNumberAxis1.setUpperMargin(0.12D);
        localNumberAxis1.setStandardTickUnits(
                NumberAxis.createIntegerTickUnits());

        NumberAxis localNumberAxis2 = (NumberAxis) localXYPlot.getRangeAxis();

        localNumberAxis2.setAutoRangeIncludesZero(false);

        Font localFont = new Font("Ubuntu", 1, 20);
        XYTextAnnotation localXYTextAnnotation = new XYTextAnnotation("-3", 60, SD3Neg);
        localXYTextAnnotation.setFont(localFont);
        localXYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        localXYPlot.addAnnotation(localXYTextAnnotation);

        localXYTextAnnotation = new XYTextAnnotation("-2", 60, SD2Neg);
        localXYTextAnnotation.setFont(localFont);
        localXYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        localXYPlot.addAnnotation(localXYTextAnnotation);

        localXYTextAnnotation = new XYTextAnnotation("-1", 60, SD1Neg);
        localXYTextAnnotation.setFont(localFont);
        localXYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        localXYPlot.addAnnotation(localXYTextAnnotation);

        localXYTextAnnotation = new XYTextAnnotation("0", 60, SD0);
        localXYTextAnnotation.setFont(localFont);
        localXYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        localXYPlot.addAnnotation(localXYTextAnnotation);

        localXYTextAnnotation = new XYTextAnnotation("1", 60, SD1);
        localXYTextAnnotation.setFont(localFont);
        localXYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        localXYPlot.addAnnotation(localXYTextAnnotation);

        localXYTextAnnotation = new XYTextAnnotation("2", 60, SD2);
        localXYTextAnnotation.setFont(localFont);
        localXYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        localXYPlot.addAnnotation(localXYTextAnnotation);

        localXYTextAnnotation = new XYTextAnnotation("3", 60, SD3);
        localXYTextAnnotation.setFont(localFont);
        localXYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        localXYPlot.addAnnotation(localXYTextAnnotation);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesPaint(1, Color.ORANGE);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesPaint(2, Color.YELLOW);
        renderer.setSeriesShapesVisible(2, false);
        renderer.setSeriesPaint(3, Color.GREEN);
        renderer.setSeriesShapesVisible(3, false);
        renderer.setSeriesPaint(4, Color.YELLOW);
        renderer.setSeriesShapesVisible(4, false);
        renderer.setSeriesPaint(5, Color.ORANGE);
        renderer.setSeriesShapesVisible(5, false);
        renderer.setSeriesPaint(6, Color.RED);
        renderer.setSeriesShapesVisible(6, false);
        renderer.setSeriesLinesVisible(7, false);
        renderer.setSeriesVisibleInLegend(7, false);
//        renderer.setSeriesShape(7, new Rectangle(0, 0, tamanoFigura, tamanoFigura));

        localXYPlot.setRenderer(renderer);

        if (sexo.equals("m")) {
            System.setProperty("myColor", "0X4286f4");
        } else {
            System.setProperty("myColor", "0XEAB1B1");
        }

        localXYPlot.setBackgroundPaint(Color.getColor("myColor"));

        return localJFreeChart;
    }

    public JPanel createDemoPanel() {
        JFreeChart localJFreeChart = createChart(createDataset());
        localJFreeChart.setBackgroundPaint(Color.WHITE);
        ChartPanel localChartPanel = new ChartPanel(localJFreeChart);
        localChartPanel.setMouseWheelEnabled(true);//Zoom Deshabilitado
        return localChartPanel;
    }
}
