package com.command.sdk;

public class Command {

	private static final byte ESC = 0x1B;
	private static final byte FS = 0x1C;
	private static final byte GS = 0x1D;
	private static final byte US = 0x1F;
	private static final byte DLE = 0x10;
	private static final byte DC4 = 0x14;
	private static final byte DC1 = 0x11;
	private static final byte SP = 0x20;
	private static final byte NL = 0x0A;
	private static final byte FF = 0x0C;
	public static final byte PIECE = (byte) 0xFF;
	public static final byte NUL = (byte) 0x00;
	
	//打印机初始化    -- Inicialización de impresora
	public static byte[] ESC_Init = new byte[] {ESC, '@' };
	
	/**
	 * 打印命令     -- Orden de impresión
	 */
	//打印并换行    -- Imprimir y envolver
	public static byte[] LF = new byte[] {NL};
	
	//打印并走纸     -- Imprima y Toma el papel
	public static byte[] ESC_J = new byte[] {ESC, 'J', 0x00 };
	public static byte[] ESC_d = new byte[] {ESC, 'd', 0x00 };
	
	//打印自检页     -- Imprima una página de autodiagnóstico
	public static byte[] US_vt_eot = new byte[] {US, DC1, 0x04 };
	
	 //蜂鸣指令     -- Instruccion de pitido
    public static byte[] ESC_B_m_n = new byte[] {ESC, 'B', 0x00, 0x00 };
	
    //切刀指令     -- Instrucciones de corte
    public static byte[] GS_V_n = new byte[] {GS, 'V', 0x00 };
    public static byte[] GS_V_m_n = new byte[] {GS, 'V', 'B', 0x00 };
    public static byte[] GS_i = new byte[] {ESC, 'i' };
    public static byte[] GS_m = new byte[] {ESC, 'm' };
	
	/**
	 * 字符设置命令     -- Comando de conjunto de caracteres
	 */
	//设置字符右间距    --  Establecer el espaciado correcto de los caracteres
	public static byte[] ESC_SP = new byte[] {ESC, SP, 0x00 };
	
	//设置字符打印字体格式   -- Establecer el formato de fuente de impresión de caracteres
	public static byte[] ESC_ExclamationMark = new byte[] {ESC, '!', 0x00 };
	
	//设置字体倍高倍宽     -- Configure la fuente multiplicada por un ancho mayor
	public static byte[] GS_ExclamationMark = new byte[] {GS, '!', 0x00 };
	
	//设置反显打印      -- Establecer la impresión inversa
	public static byte[] GS_B = new byte[] {GS, 'B', 0x00 };
	
	//取消/选择90度旋转打印    -- Cancelar / seleccionar la impresión de rotación de 90 grados
	public static byte[] ESC_V = new byte[] {ESC, 'V', 0x00 };
	
	//选择字体字型(主要是ASCII码)    -- Seleccione la fuente de la fuente (principalmente ASCII)
	public static byte[] ESC_M = new byte[] {ESC, 'M', 0x00 };
	
	//选择/取消加粗指令    -- Seleccionar / cancelar instrucciones en negrita
	public static byte[] ESC_G = new byte[] {ESC, 'G', 0x00 };
	public static byte[] ESC_E = new byte[] {ESC, 'E', 0x00 };
	
	//选择/取消倒置打印模式   -- Seleccionar / cancelar el modo de impresión invertida
	public static byte[] ESC_LeftBrace = new byte[] {ESC, '{', 0x00 };
	
	//设置下划线点高度(字符)   -- Establecer la altura de subrayado (carácter)
	public static byte[] ESC_Minus = new byte[] {ESC, 45, 0x00 };
	
	//字符模式    -- Modo de personalizado
	public static byte[] FS_dot = new byte[] {FS, 46 };
	
	//汉字模式    -- Patrón chino
	public static byte[] FS_and = new byte[] {FS, '&' };
	
	//设置汉字打印模式    -- Establecer el modo de impresión chino
	public static byte[] FS_ExclamationMark = new byte[] {FS, '!', 0x00 };
	
	//设置下划线点高度(汉字)    -- Establecer la altura del subrayado (caracteres chinos)
	public static byte[] FS_Minus = new byte[] {FS, 45, 0x00 };
	
	//设置汉字左右间距    -- Establecer el espaciado de los caracteres chinos a izquierda y derecha
	public static byte[] FS_S = new byte[] {FS, 'S', 0x00, 0x00 };
	
	//选择字符代码页   -- Seleccione la página de códigos de caracteres
	public static byte[] ESC_t = new byte[] {ESC, 't', 0x00 };
	
	/**
	 * 格式设置指令     -- Instrucciones de formateo
	 */
	//设置默认行间距    -- Establecer el espaciado de línea predeterminado
	public static byte[] ESC_Two = new byte[] {ESC, 50}; 
	
	//设置行间距    -- Establecer el espaciado entre líneas
	public static byte[] ESC_Three = new byte[] {ESC, 51, 0x00 };
	
	//设置对齐模式   -- Establecer el modo de alineación
	public static byte[] ESC_Align = new byte[] {ESC, 'a', 0x00 };
	
	//设置左边距    -- Establecer el margen izquierdo
	public static byte[] GS_LeftSp = new byte[] {GS, 'L', 0x00 , 0x00 };
	
	//设置绝对打印位置                              -- Establezca la posición de impresión absoluta
	//将当前位置设置到距离行首（nL + nH x 256）处。   -- Establezca la posición actual en el encabezado de la línea (nL + nH x 256).
	//如果设置位置在指定打印区域外，该命令被忽略       -- Este comando se ignora si la posición de configuración está fuera del área de impresión especificada
	public static byte[] ESC_Relative = new byte[] {ESC, '$', 0x00, 0x00 };
	
	//设置相对打印位置    -- Establecer la posición de impresión relativa
	public static byte[] ESC_Absolute = new byte[] {ESC, 92, 0x00, 0x00 };
	
	//设置打印区域宽度   -- Establecer el ancho del área de impresión
	public static byte[] GS_W = new byte[] {GS, 'W', 0x00, 0x00 };

	/**
	 * 状态指令    -- Instrucciones de estado
	 */
	//实时状态传送指令   -- Instrucciones de transferencia de estado en tiempo real
	public static byte[] DLE_eot = new byte[] {DLE, 0x04, 0x00 };
	
	//实时弹钱箱指令    -- Instrucción de cajón de efectivo en tiempo real
	public static byte[] DLE_DC4 = new byte[] {DLE, DC4, 0x00, 0x00, 0x00 };
	
	//标准弹钱箱指令    -- Instrucción de cajón de efectivo estándar
	public static byte[] ESC_p = new byte[] {ESC, 'F', 0x00, 0x00, 0x00 };
	
	/**
	 * 条码设置指令    -- Instrucciones de configuración del código de barras
	 */
	//选择HRI打印方式   -- Seleccione el modo de impresión HRI
	public static byte[] GS_H = new byte[] {GS, 'H', 0x00 };
	
	//设置条码高度    -- Establecer la altura del código de barras
	public static byte[] GS_h = new byte[] {GS, 'h', (byte) 0xa2 };
	
	//设置条码宽度   -- Establecer el ancho del código de barras
	public static byte[] GS_w = new byte[] {GS, 'w', 0x00 };
	
	//设置HRI字符字体字型   -- Establecer fuente de fuente de caracteres HRI
	public static byte[] GS_f = new byte[] {GS, 'f', 0x00 };
	
	//条码左偏移指令  -- Instrucciones del código de barras de desplazamiento a la izquierda
	public static byte[] GS_x = new byte[] {GS, 'x', 0x00 };
	
	//打印条码指令   -- Imprimir instrucciones de código de barras
	public static byte[] GS_k = new byte[] {GS, 'k', 'A', FF };

	//二维码相关指令	-- Instrucciones relacionadas con el código bidimensional
    public static byte[] GS_k_m_v_r_nL_nH = new byte[] { ESC, 'Z', 0x03, 0x03, 0x08, 0x00, 0x00 };
	
}
