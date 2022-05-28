#define HIGHP

uniform float u_time;
uniform sampler2D u_texture;

varying vec2 v_texcoord;

void main()
{
    float t = u_time * 0.01;
    vec4 color = texture2D(u_texture, v_texcoord);
    color *= vec4(abs(sin(t)), abs(sin(t * 2.0)), abs(sin(t * 4.0)), 0.5);

    gl_FragColor = color;
}
