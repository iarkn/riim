attribute vec2 a_position;
attribute vec2 a_texCoord0;

varying vec2 v_texcoord;

void main()
{
    v_texcoord = a_texCoord0;
    gl_Position = vec4(a_position, 0.0, 1.0);
}
