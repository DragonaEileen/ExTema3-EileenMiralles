package fecha;

/**
 * Clase que contiene los atributos día, mes y año y métodos para observar la fecha
 * 
 * @author Elena
 */
public class Fecha {
	
	/* Atributos */
	/**
	 * Valor del día
	 */
	private int d; //d�a
	
	/**
	 * Valor del mes
	 */
	private int m; //mes
	
	/**
	 * Valor del año
	 */
	private int a; //a�o

	/* Constructors */
	/**
	 * Constructor SIN Parámetros
	 */
	public Fecha() {

	}

	/**
	 * Constructor CON Parametros
	 * 
	 * @param dia Valor del día
	 * @param mes Valor del mes
	 * @param anio Valor del año
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	/* Metodos */
	/**
	 * Método que comprueba si los valores del año, mes y dia son correctos o válidos
	 * 
	 * @return diaCorrecto&&mesCorrecto&&anioCorrecto Booleano que indica si los datos son válidos
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Método privado que devuelve true si un año es bisiesto, o false si no
	 * 
	 * @return esBisiesto Booleano que indica si un año es bisiesto
	 */
	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Metodo que suma un día a la fecha
	 */
	// M�todo diaSiguiente
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Metodo que devuelve una Cadena compuesta por la fecha
	 * 
	 * @return cadena Cadena compuesta por el día, el mes y el año separados por guiones
	 */
	// M�todo toString
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
