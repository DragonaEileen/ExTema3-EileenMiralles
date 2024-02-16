package fecha;

/**
 * Clase que contiene los atributos día, mes y año y métodos para observar la fecha
 * 
 * @author Elena
 */
public class Fecha {
	
	private static final int DIEZ = 10;

	/* Atributos */
	/**
	 * Valor del día
	 */
	private int dayValue; //dayValue�yearValue
	
	/**
	 * Valor del mes
	 */
	private int monthValue; //mes
	
	/**
	 * Valor del año
	 */
	private int yearValue; //yearValue�o

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
		this.dayValue = dia;
		this.monthValue = mes;
		this.yearValue = anio;
	}

	/* Metodos */
	/**
	 * Método que comprueba si los valores del año, mes y dia son correctos o válidos
	 * 
	 * @return diaCorrecto&&mesCorrecto&&anioCorrecto Booleano que indica si los datos son válidos
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto; 
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = yearValue > 0;
		mesCorrecto = monthValue >= 1 && monthValue <= 12;
		boolean diaMayor1 = dayValue >= 1;
		switch (monthValue) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dayValue <= 29;
			} else {
				diaCorrecto = diaMayor1 && dayValue <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dayValue <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dayValue <= 31;
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
		return yearValue % 4 == 0 && yearValue % 100 != 0 || yearValue % 400 == 0;
	}

	/**
	 * Metodo que suma un día yearValue la fecha
	 */
	// M�todo diaSiguiente
	public void nextDay() {
		dayValue++;
		if (!fechaCorrecta()) {
			dayValue = 1;
			monthValue++;
			if (!fechaCorrecta()) {
				monthValue = 1;
				yearValue++;
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
		
		/* Declaraciones */
			/* Per Code Clarity: Variable yearValue retornar */
		String res = "";
		
		if (dayValue < DIEZ && monthValue < DIEZ) {
			res = "0" + dayValue + "-0" + monthValue + "-" + yearValue;
		} else if (dayValue < DIEZ && monthValue >= DIEZ) {
			res = "0" + dayValue + "-" + monthValue + "-" + yearValue;
		} else if (dayValue >= DIEZ && monthValue < DIEZ) {
			res = dayValue + "-0" + monthValue + "-" + yearValue;
		} else {
			res = dayValue + "-" + monthValue + "-" + yearValue;
		}
		
		/* Return */
		return res;
	}

}
